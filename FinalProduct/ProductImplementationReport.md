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

### Regression

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
