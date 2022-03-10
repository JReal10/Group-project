# Team Effort Log

## Mich Hamer

### Sprint 1 (University Week 3):
* Review project with team, discuss approach and help divide tasks between members
* Setup Git SSH keys
* Learned and practiced with Git to be able to work as a team (Add, Remove, Commit, Fetch, Push, Pull, Branch & Checkout)
* Research Linear Regression and Piecewise Functions to understand maths
* Documented and recorded in markdown format on team Gitlab with latex formatted maths 
* https://cseejira.essex.ac.uk/browse/B201157-5 (completed ~3hrs)
* Linear Regression Documentation: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/4fdb67d97035aa813fbbf2252fd8d0176c5498ea

### Sprint 2 (University Week 4):
* Further research to understand linear regression in more detail; improved markdown documentation of linear regression
* Created model and estimator interfaces to allow rest of group to use generic interfaces to unblock their tasks
* Created linear regression implementation of model and estimator interfaces
* Created tests for linear regression model which can also function as examples for team members who need to use the model
* Learned more about Git (Rebase, Merge & Conflict resolution) as well as general Git workflow types
* Discussed with team to help members set up Git SSH keys & relevant software
* https://cseejira.essex.ac.uk/browse/B201157-13 (completed ~4hrs)
* Improvement made to Linear Regression documentation: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/54a164162b598c2769d0f1240808f524767ce605
* Linear Regression Implementation: https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/1c9c3cf3338728e0718ff5cc9561fb6a66a22ec7

### Sprint 3 (University Weeks 5 & 6):
* Assisted team with Git usage & supported team with general approaches to tasks
* https://cseejira.essex.ac.uk/browse/B201157-13 (research completed ~4hrs, implementation not completed)
* Further research & documentation on Piecewise Linear Regression https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/2a7b2305b0d8e40835e31e84523d85c37babc7af
* Assisted Jacob with downloading CSV data due to bug with extracting gzip compressed data https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/bfb6a04d7b70776ccde20c2a9d5e230a1626c9e8
* Fixed error handling, converted CSV string data into usable format & refactored CSV code to be usable in application https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/4d4cc597897fd60094e26fdb767a1c8a035e898c
* Added CSV downloading, reading & redownload features to GUI with error handling & dialogs https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/89099e32732ef7c8773777ac2c931b05e09de621
* Added basic plotting component with dummy data https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/80e466575ef9feb20a1f9760043af3518eb2c528
* Fixed some additional minor bugs in application

### Sprint 4 (University Week 7):
* Finalize MVP https://cseejira.essex.ac.uk/browse/B201157-26 (completed ~6hrs) https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/848a3741002d3a245daa5070155a24bc2c73f294
    1. Prepare data for graph https://cseejira.essex.ac.uk/browse/B201157-28 (completed)
    2. Prepare data for model https://cseejira.essex.ac.uk/browse/B201157-29 (completed)
    3. Display model prediction on graph https://cseejira.essex.ac.uk/browse/B201157-30 (completed)
* Add ability for both death & case graphs/predictions to be displayed in separate tabs https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/848a3741002d3a245daa5070155a24bc2c73f294
* Minor code refactoring
* Complete Team effort log

### Sprint 5 (University Weeks 17 & 18):
* Fix initialization crash on application launch due to unexpected filesystem state https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/a36807707745ebd10cc87cfc8b70426143953049
* Add table interface to display specific values for the next 7 days of predictions https://cseejira.essex.ac.uk/browse/B201157-39
* Fix network failure bug https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/1c7ac804f53b76cec44bacc32d4e2b8646499093
* Divide remaining possible tasks among team members to ensure they all have made code contributions
* Advise team members on possible methods of implementation for tasks

### Sprint 6 (University Week 19 & 20):
* Implement piecewise regression estimator and model https://cseejira.essex.ac.uk/browse/B201157-41
* Modify plot to render a piecewise regression line instead of a single linear regression linear https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/01f61a5273b01d111472a9148865e517cbbe62be
* Major rebase and fix conflicts of all outstanding team member's branches to allow them to merge into master
* Add header to table to improve user experience https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/83f81998d91c4ca2bfba140a8c0c98b89b8638f1
* Fix table interface bug causing only case predictions to be displayed https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/83f81998d91c4ca2bfba140a8c0c98b89b8638f1
* Fix bug with piecewise regression causing many knot points to be very close together https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/3ca3259177ed58ea75e5b696d340f0dae8dc74bb

### Sprint 7 (University Week 21 & 22):
* Prepare repository for team members to begin writing tasks and avoid merge conflicts https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/418ff1ae75e0efd359467aeb7675e83079ad54f0
* Divide documentation tasks among team members and ensure all are comfortable with their tasks
* Fix missing project dependencies https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/0dbe0bf960b992bc9b97dadab9bfd76066b4b751
* Advise team members on possible content for documentation tasks
* Fix plot displaying cumulative data instead of daily changes https://cseejira.essex.ac.uk/browse/B201157-44
* Code cleanup of style inconsistencies (various)
* Adjust model extrapolation period https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/341cc9c71438530bb655b94971ac6f308cafd262
* Document application implementation https://cseejira.essex.ac.uk/browse/B201157-49
* Build project jar file & test functionality https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/blob/30a389d4f45b79e82513d5ef3e29316fe2a5c0eb/FinalProduct/project.jar
* Complete team effort log https://cseejira.essex.ac.uk/browse/B201157-53
* Create README.md to document how to run the program https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/0d3fd483abacd8c5a414ecf0575812adb18a8e5e
* Create submission document

## Durga Wigton

### Sprint 1 (University Week 3):
* Read project on Moodle
* Research format of existing data on NHS website
* Sign into Gitlab & Jira
* User Interfaces
* [Link to User Interfaces](https://cseejira.essex.ac.uk/browse/B201157-6)
* 1 day
* Research to find out if there is an internal Java library for displaying data.
Upload findings to GitLab.
Java Swing can be used for plotting graphs, creating buttons & tables
* Tutor meeting with Dr Liang Hu at 1400hrs on 20/10/21 to discuss any issues.

### Sprint 2 (University Week 4):
* User Stories
* [Link to User Stories](https://cseejira.essex.ac.uk/browse/B201157-10)
* 1 day
* Create 3 User Personas:
1. Patricia Jones (NHS Manager)
2. Mary McLeod (Retired Carer)
3. James Johnson (Teacher)
 Upload User Stories to Jira and GitLab.
* Experiment with command line git (cloning, fetching, committing, branches etc..) to learn how it works and be able to use it in the project

### Sprint 3 (University Weeks 5 & 6):
* Downloading/reading files implementation - Data Analysis
* [Link to Data Analysis](https://cseejira.essex.ac.uk/browse/B201157-16)
* 2 days
*	Data to be read from the website and plotted in a graph with dates on the x-axis and cumulative death rates and Covid cases on the y-axis.
	Information in Array needs to be converted to date format so that it can be displayed and analysed.
	Created DateParser.java and DateParserTest.java.
	Downloaded test data to GitLab.

### Sprint 4 (University Week 7):
*	Complete Risk Log
*	[Link to Risk Logs](https://cseejira.essex.ac.uk/browse/B201157-20)
*	1 day
*	Complete 4 Risk Logs:
	1. [Link to Covid Transmission Prevention Risk Log](https://cseejira.essex.ac.uk/browse/B201157-32)
	2. [Link to Inability of Team Members to attend meetings Risk Log](https://cseejira.essex.ac.uk/browse/B201157-33)
	3. [Link to Failure of Computers Risk Log](https://cseejira.essex.ac.uk/browse/B201157-34)
	4. [Link to Inadequate Final Product Risk Log](https://cseejira.essex.ac.uk/browse/B201157-35)
*	Complete team effort log – Durga Wigton
*	1 day
*	Write my part of the team effort log
*	Scrum Master
*	Completed team effort log – Durga Wigton
* [Link to Team Effort Log](https://cseejira.essex.ac.uk/browse/B201157-23)
1 day

### Challenge Week (University Week 16)

### Sprint 5 (University Weeks 17 & 18):
* Extend regression line to make prediction for the next month.
Research online forums, jfreechart libraries and source code to find ways to extend regression line to make a prediction line.
Add another series to ChartDisplay.java to make prediction line and uploaded it to GitLab.
* [Link to Extrapolated Regression Line](https://cseejira.essex.ac.uk/browse/B201157-43)
2 days

### Sprint 6 (University Week 19 & 20):
* Format prediction line (colour and dotted line).
Research ways to change formatting of the graph by looking on the internet, forums and jfreechart libraries.
Update ChartDisplay.java and upload it to GitLab.
* [Link to Extrapolated Regression Line](https://cseejira.essex.ac.uk/browse/B201157-43)
* 2 days

### Sprint 7 (University Week 21 & 22):
* Complete Product marketing Plan.
Carry-out marketing research for the final product.
* [Link to Product Marketing Plan](https://cseejira.essex.ac.uk/browse/B201157-52)
Upload the marketing report as a markdown document on GitLab.
* 2 days
* Complete my part of Team Effort Log for Final Product as a markdown document with links to Jira and upload it to GitLab.
* (https://cseejira.essex.ac.uk/browse/B201157-55)
* 1 day

## Jacob Hinton

### Sprint 1 (University Week 3):
* Data Input
* https://cseejira.essex.ac.uk/browse/B201157-2
* 1 day
* Research ways of reading/downloading from websites automatically on program execution and having the csv read into a list or similar
No project code, only test code to understand how to implement it
### Sprint 2 (University Week 4):
* Familiarise with command line cseegit 
* https://cseejira.essex.ac.uk/browse/B201157-9
* 1 day
* Experiment with command line git (cloning, fetching, committing, branches etc..) to learn how it works and be able to use it in the project
* No project code
* Read from NHS website
* https://cseejira.essex.ac.uk/browse/B201157-11
* 2 days
* Implement a way to download from the nhs website the relevant csv’s and read them into arrays
* Wrote Read.java (later became CsvLoader.java) that downloads and reads the csv from the nhs website
### Sprint 3 (University Weeks 5 & 6):
* Scrum master
* Downloading/Reading Files implimentation
* https://cseejira.essex.ac.uk/browse/B201157-15
* 1 day
* Continuation from last sprints “Read from NHS website” with a heavy focus on downloading the files as reading was finished the week before
* Continued work on Read.java and the creation of ReadTest.java for testing.
### Sprint 4 (University Week 7):
* Complete team effort log - Jacob Hinton
* https://cseejira.essex.ac.uk/browse/B201157-21
* 1 day
* Write my part of the team effort log
* No code
* Complete requirements
* https://cseejira.essex.ac.uk/browse/B201157-27
* 1 day
* Complete the requirements section of the MVP
* No code
### Sprint 5 (University Week 17 & 18):
* PDF generation
* https://cseejira.essex.ac.uk/browse/B201157-7
* 1 day
* Working with selda to create the PDF functionality (selda turns the graphs to images and i create the image of the table and use the images alongside the pdfbox library to create the pdf)
### Sprint 6 (University Week 19 & 20):
* PDF generation
* https://cseejira.essex.ac.uk/browse/B201157-7
* NA
* adapting program to make presentation a bit better and optimising code 
### Sprint 7 (University Week 21 & 22):
* Project Management Log
* https://cseejira.essex.ac.uk/browse/B201157-47
* 1 day
* writing the project Management log for the final writeup
* no code
* Team Effort Log
* https://cseejira.essex.ac.uk/browse/B201157-7
* 1 day
* Completing my part of the team effort Log

## Roan John

### Sprint 1 (University Week 3):
* Data processing
* https://cseejira.essex.ac.uk/browse/B201157-4
* 1 day
* Get an idea on how the data would be taken from the CSV files and put into the linear regression algorithm
* No code involved, more an analysis on the existing code

### Sprint 2 (University Week 4):
* Initial thoughts on design
* https://cseejira.essex.ac.uk/browse/B201157-8
* 2 days
* Get an idea on how the GUI might look and be implemented, specifically knowing what content will be displayed on it and what components we might use to implement it.
 
### Sprint 3 (University Weeks 5 & 6):
* Implementing a GUI
* https://cseejira.essex.ac.uk/browse/B201157-14a
* 3 days
* Implement a working GUI with Java
* https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/dfe43b62a81d706e8be2eb77a14119f11158dd08
* Was scrum master this week


### Sprint 4 (University Week 7):
* Complete team effort log & fix issue in GUI
* https://cseejira.essex.ac.uk/browse/B201157-22
* 1 day
* Fixed a relative path bug in the GUI code and updated the team effort log
* https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/c9f0a3cbe8e0f1b4dd09b02014e8106e3e96fffa

### Sprint 5 (University Week 17 & 18):
* Research about JUnit testing 
* https://cseejira.essex.ac.uk/browse/B201157-40
* 1 day
* Research and figure out what is necessary to use from the JUnit framework and what components of the project require testing

### Sprint 6 (University Week 19 & 20):
* Implementation of the JUnit framework
* https://cseejira.essex.ac.uk/browse/B201157-40
* 3 days
* Implementing the JUnit framework to the necessary components that require testing within our project 
* https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/f584ab0006ecd4e9e67ecfc4d226ccc20d71bc1c

### Sprint 7 (University Week 21 & 22):
* Product Testing Log
* https://cseejira.essex.ac.uk/browse/B201157-50
* 1 day
* Write a brief summary on all the testing we did for the project.

## Jamie Ogundian
### Sprint 1 (University Week 3):
* Research plotting
* https://cseejira.essex.ac.uk/browse/B201157-3
* It was set and completed in sprint 2. It took 1 hour.
* Research ways of plotting charts in java. 
* No code to display at this point as I only researched different ways of plotting. 

### Sprint 2 (University Week 4)
* Create plot component
* https://cseejira.essex.ac.uk/browse/B201157-17
* It was set and continued in sprint 3. I worked on it for a day.
* implement JavaFX to vscode
* Getting used to GitLab and Jira
* No code to display, since JavaFX need to be implemented ob VScode to plot graphs

### Sprint 3 (University Week 5&6)
* Create plot component
* https://cseejira.essex.ac.uk/browse/B201157-17
* It was set and completed in sprint 4. I worked on it for 2 days.
* Continuation on creating plot components from sprint 2.
* implement plot component using JavaFX
* https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/d45a329b11b13f237d720c0360f7944ed72c6942
* implemented and changed the basic JavaFX line graph from: https://docs.oracle.com/javafx/2/charts/line-chart.htm  

### Sprint 4(University week 7)
* Updating team effort log
* https://cseejira.essex.ac.uk/browse/B201157-24
* It was set and completed in sprint sprint 5. I worked on it for a day.
* updating my team effort log.
* Since implementing JavaFX was not working on VScode, we decided not to use JavaFX and use another plot library(implemented by Mich)
* No code to display


## Selda Ozturkmen

### Sprint 1 (University Week 3):
* Read the project on Moodle
* Research and understand how to generate a PDF file
* Day 2
* Learn how to output the data in a png file first
* No code to display, only researched to have an understanding on what to docs

### Sprint 2 (University Week 4):
* Research how to generate a png file
* Learn how to convert png files into pdf files
* Getting used to GitLab and Jira

### Sprint 3 (University Week 5,6 & 7):
* Try outputing the graph in a png format
* https://cseejira.essex.ac.uk/browse/B201157-61
* Merging my code of outputting a png file of the graph 
* Merging it with the rest of the code
* ce52fd50

