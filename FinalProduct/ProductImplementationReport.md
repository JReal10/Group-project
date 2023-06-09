# Team Implementation Report

## Technical Diagrams
![Class Diagram](Images/class_diagram.png)

## Technical Description

### Data IO

#### CSV Loader
The CSV loader handles downloading, caching and parsing of the CSV available from the gov.uk coronavirus API. Data CSVs
from the government API is saved on disk in a cache to prevent rapid API requests and to speed up application startup.
If the cache is empty then the CSV loader will download a new CSV and ensure folders are created for the cache to be
stored in. CSV data is parsed after either being downloaded or read from the local cache to produce arrays of doubles
representing the numbers of cases and deaths downloaded from the web API, as well as an array of dates for each value.
The CSV loader provides the ability to redownload data incase of the cached data being out of date.

Cached CSV data is loaded from file if it exists, otherwise the application will download new data from the remote
government API.
```java
File f = new File(filename);
if (!f.exists()) {
    update();
} else {
    readCsv();
}
```

#### Data Repo
The data repo is a wrapper class around the CSV loader that processes the dates parsed from the web API into day offset
values, which can be used with the graph and regression calculations. The data repo is what the rest of the application
interacts with, instead of the CSV loader directly.

### Regression

The regression package has two main types of classes, that each implement a specific interface; Estimators and Models.
Models are a simple interface with a single predict method, which takes an X value and predicts a Y value using a
pre-initialized model. The model is initialized by a specific implementation of the Estimator interface; an Estimator
will take a set of values, and calculate a model that will fit the data provided. There are  2 types of Estimator
implementations in our program, an estimator that uses ordinary least squares (OLSEstimator), as well as an estimator
that performs piecewise linear regression. Both Estimators will return a generic object that implements the Model
interface that can be used to predict a Y value for any provided X value.

Producing the linear model via the OLS Estimator is performed with the following getModel function from the
Estimator interface.
```java
@Override
public Model getModel(double[] xValues, double[] yValues) {
    double xMean = getMean(xValues);
    double yMean = getMean(yValues);
    double coefficient = getCoefficient(xValues, yValues, xMean, yMean);
    double constant = getConstant(xMean, yMean, coefficient);
    return new LinearModel(coefficient, constant);
}
```

Producing a piecewise model is by performed by the Piecewise Estimator with it's own getModel function. A piecewise
model is made up of multiple linear models, which are individually calculated using OLS estimators.
```java
@Override
public Model getModel(double[] xValues, double[] yValues) {
    numModels = xValues.length / sliceSize - 1; // model per fortnight
    ArrayList<ModelAndBound> candidateModels = new ArrayList<>(xValues.length - (numModels - 1));
    double[] xCandidate = new double[sliceSize];
    double[] yCandidate = new double[sliceSize];
    OLSEstimator ols = new OLSEstimator();
    for (int i = 0; i <= xValues.length - sliceSize; i += sliceSize) {
        for (int j = 0; j < sliceSize; j++) {
            xCandidate[j] = xValues[i + j];
            yCandidate[j] = yValues[i + j];
        }
        ModelAndBound candidateModel = new ModelAndBound((LinearModel) ols.getModel(xCandidate, yCandidate), i);
        candidateModels.add(candidateModel);
    }
    // get turning points where the difference in gradients are the greatest
    int[] turningPoints = getTurningPoints(candidateModels);
    LinearModel[] models = getModels(xValues, yValues, turningPoints);
    double[] bounds = new double[turningPoints.length];
    for (int i = 0; i < turningPoints.length; i++) {
        bounds[i] = xValues[turningPoints[i]];
    }
    bounds[turningPoints.length - 1] = xValues[xValues.length - 1];
    return new PiecewiseModel(models, bounds);
}

```

CSV data is downloaded from the remote API and the gzipped stream is extracted. The API URL has been modified to
download both cases and deaths in a single request to help reduce the required number of network requests.
```java
private void downloadCsv() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
    HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
    if (response.statusCode() != 200) throw new IOException("received response code: " + response.statusCode());
    try {
        var gzip = new GZIPInputStream(response.body());
        ensureDirExists();
        Path pathToFile = Paths.get(filename);
        Files.copy(gzip, pathToFile.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);
    } catch (ZipException e) {
        throw new IOException("unable to read gzip compressed csv");
    }
}
```

### GUI

The GUI is primarily displayed within a single JFrame, with a tabbed view to alternate between case and death data
views. The user selects options in the tabbed view to select the data category they would like to view and the 
relevant graph with it's appropriate model prediction line displayed.

The plots are displayed using JFreeChart as scatter plots, with data series being displayed on the plot itself and a
model is generated from the data to generate a model line that can display to the user.

```java
model = refreshModel(dayOffsets, yvalues);
```

The model is then used to generate the regression lines matching the piecewise plot, the piecewise model line is split up into
many smaller linear regression lines which are rendered individually.

```java
double first = 0;
for (double bound : model.getBounds()) {
    double x1 = first;
    double x2 = bound;
    double y1 = model.predict(x1);
    double y2 = model.predict(x2);
    XYAnnotation modelLine = new XYLineAnnotation(x1, y1, x2, y2);
    plot.addAnnotation(modelLine);
    first = bound;
}
```

The interface has buttons for a few additional features; a button that provides the ability to reload data from the
remote API, a button that outputs a PDF report of the data and model loaded in the program, as well as a button to
display a table view of the next 7 days of predictions.

Downloading the new data is triggered by a ReloaderHandler, which is attached to listen for button click events for
the reload button. Incase of failed the reload handler with prompt the user and ask what to do; failure is likely in
this case due to network requests being made, as well as file IO.

```java
private class ReloadHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        for (; ; ) {
            try {
                data.refresh();
                JOptionPane.showMessageDialog(parent, "Successfully downloaded new data", "Success", JOptionPane.INFORMATION_MESSAGE);
                return;
            } catch (IOException e) {
                int result = JOptionPane.showConfirmDialog(parent, "Failed to update data, try again?\nError: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                if (result == 0) continue;
                else break;
            }
        }
    }
}
```



The table is displayed in it's own JFrame window after the user selects the button. The table populates itself using
the Model provided by calculating the prediction for each day. The table displays the results from both case
and death models in a single view and so requires both models to be populated.


```java
private class TableHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        TableFrame frame = new TableFrame(data);
        frame.setLocationRelativeTo(parent);
    }
}
```


PDF generation uses the plots and tables from the components to produce an output report including this
information and writes it to the project root directory, reducing code duplication. The PDF generation is triggered
after the user clicks the relevant button and the ExportHandler ActionListener for the button fires.


```java
private class ExportHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        // generate pdf
    }
}
```

*This section should describe the software implementation in prose form.  Focus on how the code was designed and built.* 
*It should make a clear description that could be used by any future developers to maintain and extend your code, if necessary.*
*Describe important functions / classes / class hierarchies.*
*In this section, you should also wish to highlight any technical achievements your team is particularly proud of, including relevant code snippets.*

## Algorithms and Data Structures

#### Algorithm: Ordinary Least Squares
Ordinary least squares is used to calculate an optimum regression line to fit the parametrized data by minimising the
squared residuals of the resultant regression line. A straight line function has two components; a gradient and a
constant intercept. Calculating the gradient is performed as follows


$`\hat\beta=\displaystyle\frac{\sum(x_i-\bar x)(y_i-\bar y)}{\sum(x_i-\bar x)^2}`$


Calculating the intercept is then calculated using:


$`\hat\alpha=\bar y-\hat\beta \bar x`$


The estimator then returns a Linear Model object with these parameters.


Runtime efficiency of the algorithm can be calculated by inspecting the individual operations performed during the algorithm.


The first operations performed are calculations of the mean for both the x and the y values; each taking O(n) time.


```java
private double getMean(double[] values) {
    double sum = Arrays.stream(values).sum();
    return sum / values.length;
}
```


After both means have been calculated, the program calculates the gradient coefficient, which
involves iterating over every element in each array at the same time, this therefore is also an O(n) operation.


```java
private double getCoefficient(double[] xValues, double[] yValues, double xMean, double yMean) {
    double numerator = 0;
    double denominator = 0;
    for (int i = 0; i < xValues.length; i++) {
        double xDiff = xValues[i] - xMean;
        double yDiff = yValues[i] - yMean;
        numerator += xDiff * yDiff;
        denominator += xDiff * xDiff;
    }
    return numerator / denominator;
}
```


Finally the algorithm calculates the constant intercept value for the line, which is an O(1) operation.


```java
private double getConstant(double xMean, double yMean, double coefficient) {
    return yMean - coefficient * xMean;
}
```


This means that ignoring constant factors, the overall runtime efficiency is O(n).

#### Data Structure: Array for dates, cases and deaths data
The number of cases and deaths are stored in a plain arrays of doubles, while the parsed dates are stored in an array of
Date objects.


```java
private Date[] dates;
private double[] cases;
private double[] deaths;
```


The data when being loaded from the CSV file is initially stored into an ArrayList, however this is copied
into a standard fixed sized array once the size is known.


```java
dates = datesList.toArray(new Date[datesList.size()]);
cases = casesList.stream().mapToDouble(i -> i).toArray();
deaths = deathsList.stream().mapToDouble(i -> i).toArray();
```


The reason for the choice of an array is an attempt to make use of the data
require as little knowledge as possible for all team members, some of which are less confident with Java; this way no
knowledge of lists or any possible custom container objects is required.

Populating each individual element of the ArrayLists has a time complexity of
O(1); except for situations where the ArrayList is full and must be resized, in which case the entire contents of the
ArrayList at that point in time is copied into a new container with a time complexity of O(n). The average runtime
complexity of inserting an element to the ArrayList remains at O(1), as the occasional copying of elements has an
average effect of a constant factor on each insertion. Copying from the ArrayList into the arrays used throughout the rest of the program is an O(n) operation

## Imported Libraries 
- JFreeChart - Used for scatter plot generation, which is used in both the GUI application, as well as exported and
  saved in PDF form.
- PDFbox - Used to generate PDF files containing text and images for the export feature.
- JUnit - Used for some unit tests.

## Known Issues
No known issues with the application are present.
