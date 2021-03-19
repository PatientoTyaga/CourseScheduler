Iteration 2 Worksheet
=====================
Paying off Technical Debt
-------------------------



SOLID
-----

Link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/winter-2021-a03-group-10/-/issues/40

Agile Planning
--------------
We initially had the plan to start with and create the "save schedule" feature but had to change the plan and instead implemented the add schedule feature. Since we didn't have
proper sql database. We had to make a fake database and utilize its information to store the courses that the student selected.We stored that information inside an arraylist that would be 
cleared out upon refreshing or selecting a new student every single time. This way we don't need to worry about retrieving informaiton from the database for a particular student
atleast at this stage of our project. 

Added new feature - Add course.
Link for Add course feature: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/25

Pushed Feature to iteration 2 - Save schedule
Link for save schedule: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/1

We changed the description for the Add course user story and the Add course Feature

RETROSPECTIVE
-------------
Overall, the group as a whole working really well together to accomplish shared goals. However there are plenty of areas that we can improve to make 
our development process even smoother. Therefore, the team communicates well with one another and have good organization of iterations and task. 
One problem that we fixed from iteration 1, for example having different branches assigned with specific issues along with the designated task. So 
that we can all show our distribution in the project and keep a record of it. For instances, one of the group members opened an issue for refactoring the codes, https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/41
An issue for retrospective was open. https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/42 
All of them are labelled as 'High Priority' and 'To Do' since we all need to work on this right now. The branches and issues help other members to see where 
you at and do help if required.

We have 3 features for Iteration2. Created several issues for the features and assigned them.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/48
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/49
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/50

Fortunately, we are able to get the Database working and able to display 
the Database entries on the UI. https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/44. 

Working on the updated Architecture as discussed with the professor.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/39

Updating the UI in UI branch, add a new button in LoginActivityL page. 
Once we click it, we can go to Login Activity to load Student Information in Database.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/45

An additional issue from Iteration1 was Time Managemnet. Since all group members had lots of other commitments for different courses. Later on, a rough draft was laid out for group 
members assigned with various task in order to ensure smoother development, which ended up being much more fortunate. Another sector that can be improved on is having more careful code 
review for new features later on. An important measure of success would be continuing to keep all new merge request small to ensure that they be reviewed properly and less dead code. In conclusion, our 
main concern is to get the app to work first then do the functionality.

Iteration 1 Feedback fixes
--------------------------
Our main issue was that the code was structured wrong (presentation was talking to persistence layer, interface for the database was implemented incorrectly). We created new interface files and refactored how the code is communicating.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/29 (Code Smells)
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/28(DB DIP violation)

And here where we started to fix it

https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/commit/d17e99fbf9af0a55090b10bbe1495398e207ba54 (But it’s impossible to provide a link to specific commit since we have been improving the structure of the code all the time)

https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/commit/fcab418c800e24029bbb76491f1cc8f252457a3f


 
   
