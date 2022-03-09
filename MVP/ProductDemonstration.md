# Product Demonstration Report

Our product's goal is to evaluate current COVID-19 data, which is available on the UK government's website; this is done via graphing data points & producing a model of the data to predict beyond the current data into the future. Our final product displays a graph of COVID-19 cases and a graph of Deaths caused by COVID-19. The regression line is modelled using piecewise. In addition to the graphs, we implemented features such as PDF generation, Data updating and view table.

## Downloading and parsing CSV data
On startup the application will look for pre-cached CSV data, if it is found then the application will load it; if it is not found then the application will attempt to download the data from the UK government's website. In-case of errors in the downloading, reading or parsing of the data, relevant error dialogs are displayed to the user which will ask if the user wishes to retry. Data that is downloaded is parsed into data types that are useful for the rest of the program, so dates from the CSV data are parsed into dates, etc. 

## Linear Regression Model
The linear regression model takes two identically sized arrays of x and y values, it then produces a model, which is interactable using the Model interface, which allows predictions to be made via the interface. The linear regression model is created using derived formula from attempting to optimize the R-squared value of the model line. The description for how a line is selected is documented here: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/blob/24907f07c9d4f4c42d7b4963296d8edc830d9894/research/linear_regression/linear_regression.md

## User interface
The parsed CSV data and model are passed to the graph component. The graph component is able to display a scatter plot of the data points from the COVID-19 data, while drawing a line to match the generated prediction model. The graph is capable of being zoomed and of being updated with new data points. The user can use the tabs on the user interface to select if they would like to display graphs for cases data or for deaths data, both of which have separate models for prediction that are displayed alongside the relevant data. The user also has the ability to force the application to redownload updated data incase it has not been updated for a while, or the application has been running for a long time.

## Demonstration from the user's perspective

When starting the application, the application will attempt to display the following graph, which will show the CSV data either obtained from the file cache or by downloading from the government's website via their relevant data API.

![cases](Images/cases.png "user interface displaying a graph of COVID-19 case history")

If the user clicks the deaths tab on the top left of the application, it will change to displaying the data and model related to recorded COVID-19 deaths.

![deaths](Images/deaths.png "user interface displaying a graph of COVID-19 death history")

On application launch, or if the user clicks the reload button, the application will try to download new data from the government website; if this fails, it will display an error message informing the user, and asking them how they would like to proceed. If the user clicks yes, then the application will try again to download the data again; if the user clicks no or closes the error dialoge, the application will stop trying until the user clicks the reload button or restarts the application again.

![failure](Images/failure.png "user interface displaying an error after failing to downloaded updated data")

If data is successfully download, after user input informing the application to attempt to download the new data, then a dialog is displayed to the user confirming the success of the operation. This is only displayed after the user either clicks the reload data button, or after a failed download the user clicks yes on the retry dialog; in the case of the application starting from a fresh launch, the dialog is not displayed as the feedback provided to the user is in the form of the application opening successfully, and a dialog box is not needed.

![success](Images/success.png "user interface displaying a confirmation message after it successfully downloads updated data")

The application is currently not able to produce a PDF output, and this would be something that we would be likely to add in the finished product. We would also like to improve the model so it fits the data more than it currently does, using piecewise linear regression as we have documented here: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/blob/ce3f6a85faf30ce8b354c7a9cef1d40f259ebbe8/research/linear_regression/piecewise.md

