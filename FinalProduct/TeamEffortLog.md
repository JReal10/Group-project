# Team Effort Log
*In this section, add a heading for each team member, and under it add the sub headings "Sprint 1, Sprint 2, ..., Sprint N", as illustrated below.  Each team member can be responsible for writing their own section.*

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

## Durga Wigton

Sprint 1 (University Week 3):
*	Read project on Moodle
*	Research format of existing data on NHS website
*	Sign into Gitlab & Jira
*	User Interfaces
*	https://cseejira.essex.ac.uk/browse/B201157-6
*	1 day
*	Research to find out if there is an internal Java library for displaying data.
Upload findings to GitLab.
Java Swing can be used for plotting graphs, creating buttons & tables
*	Tutor meeting with Dr Liang Hu at 1400hrs on 20/10/21 to discuss any issues.
Sprint 2 (University Week 4):
*	User Stories
*	https://cseejira.essex.ac.uk/browse/B201157-10
*	1 day
*	Create 3 User Personas:
1. Patricia Jones (NHS Manager)
2. Mary McLeod (Retired Carer)
3. James Johnson (Teacher)
Upload User Stories to Jira and GitLab.
*	Experiment with command line git (cloning, fetching, committing, branches etc..) to learn how it works and be able to use it in the project
Sprint 3 (University Weeks 5 & 6):
*	Downloading/reading files implementation - Data Analysis
*	https://cseejira.essex.ac.uk/browse/B201157-16
*	2 days
*	Data to be read from the website and plotted in a graph with dates on the x-axis and cumulative death rates and Covid cases on the y-axis.
Information in Array needs to be converted to date format so that it can be displayed and analysed.
Created DateParser.java and DateParserTest.java.
Downloaded test data to GitLab.
Sprint 4 (University Week 7):
*	Complete Risk Log
*	https://cseejira.essex.ac.uk/browse/B201157-20
*	1 day
*	Complete 4 Risk Logs:
1.Covid Transmission Prevention
https://cseejira.essex.ac.uk/browse/B201157-32
2.Inability of Team Members to attend meetings
https://cseejira.essex.ac.uk/browse/B201157-33
3.Failure of Computers
https://cseejira.essex.ac.uk/browse/B201157-34
4.Inadequate Final Product
https://cseejira.essex.ac.uk/browse/B201157-35
*	Complete team effort log – Durga Wigton
*	https://cseejira.essex.ac.uk/browse/B201157-23
*	1 day
*	Write my part of the team effort log
*	Scrum Master

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


## Roan John

### Sprint 1 (University Week 3):
 - Data processing
 - https://cseejira.essex.ac.uk/browse/B201157-4
 - 1 day
 - Get an idea on how the data would be taken from the CSV files and put into the linear regression algorithm
 - No code involved, more an analysis on the existing code

### Sprint 2 (University Week 4):
 - Initial thoughts on design
 - https://cseejira.essex.ac.uk/browse/B201157-8
 - 2 days
 - Get an idea on how the GUI might look and be implemented, specifically knowing what content will be displayed on it and what components we might use to implement it.
 
### Sprint 3 (University Weeks 5 & 6):
 - Implementing a GUI
 - https://cseejira.essex.ac.uk/browse/B201157-14a
 - 3 days
 - Implement a working GUI with Java
 - https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/dfe43b62a81d706e8be2eb77a14119f11158dd08
 - Was scrum master this week


### Sprint 4 (University Week 7):
 - Complete team effort log & fix issue in GUI
 - https://cseejira.essex.ac.uk/browse/B201157-22
 - 1 day
 - Fixed a relative path bug in the GUI code and updated the team effort log
 - https://cseegit.essex.ac.uk/21-22-ce201-col/CE201_liang-3/-/commit/c9f0a3cbe8e0f1b4dd09b02014e8106e3e96fffa


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

*Repeat for each team member, i.e. with more subheadings "Sprint1, Sprint2, ... Sprint N"*

