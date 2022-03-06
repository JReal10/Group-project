# Team Implementation Report
*This section should describe the technical details of your implementation.  The subheadings and italicised text below may be used to guide you.*

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

#### Data Repo
The data repo is a wrapper class around the CSV loader that processes the dates parsed from the web API into day offset
values, which can be used with the graph and regression calculations. The data repo is what the rest of the application
interacts with, instead of the CSV loader directly.

### Regression

#### Ordinary Least Squares Estimator
Ordinary least squares is used to calculate an optimum regression line to fit the parametrized data by minimising the
squared residuals of the resultant regression line. A straight line function has two components; a gradient and a
constant intercept. Calculating the gradient is performed as follows


$`\hat\beta=\displaystyle\frac{\sum(x_i-\bar x)(y_i-\bar y)}{\sum(x_i-\bar x)^2}`$


Calculating the intercept is then calculated using:


$`\hat\alpha=\bar y-\hat\beta \bar x`$


The estimator then returns a Linear Model object with these parameters.

### GUI


*This section should describe the software implementation in prose form.  Focus on how the code was designed and built.* 
*It should make a clear description that could be used by any future developers to maintain and extend your code, if necessary.*
*Describe important functions / classes / class hierarchies.*
*In this section, you should also wish to highlight any technical achievements your team is particularly proud of, including relevant code snippets.*

## Algorithms and Data Structures
*Describe datastructures of at least one component of your implementation.*
*Describe at least one algorithm used in your implementation.*
*In both cases, describe the space / time complexity of each.*

## Imported Libraries 
*List any 3rd party libraries that were used and describe what functionality they provided.*

## Known Issues
*List any known issues (bugs) in your software, and describe workarounds if they exist.*
