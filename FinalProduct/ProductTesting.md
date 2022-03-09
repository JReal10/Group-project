# Product Testing Log


This project used the JUnit framework to test certain classes that have a predictive result.

### OLSEstimator (JUnit)

The OLSEstimator class would take an input of two arrays consisting of x and y values to build a model. The model has a prediction function would return an expected value.

Given the following X values (1,2,3,4,5,6,7,8,9,10) and Y values (3,5,7,9,11,13,15,17,19)

The following inputs should correspond with the given results

| Prediction Input | Expected Output         | 
|------------------|-------------------------
| 2                | 5.0      
| 2.5              | 6.0     
| 3                | 7.0 


### CsvLoader

The CSV loader class cannot have predictive results as the data is fetched from a public API that updates the CSV files values based on current COVID cases/death statistics. 

However we still overcame this by implementing a simple test with just a main function that would attempt to print all the values from the CSV file that was fetched.

