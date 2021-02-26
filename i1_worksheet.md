Iteration 1 Worksheet
=====================
Add Course
-----------------
As a user when I create my schedule I want to be able to add a new course to my schedule and see it on the appropriate term. 
Eg. If I select a course from the list and select the term when the course is available, 
it should display the course on the appropriate term on my schedule.
I can use the saved schedule to organize my study time when my classes are complete for the day.

Developer Tasks:

Have add course option
Have database where added courses will be stored.
Be able to display added courses for student on GUI


Tell the story of how one of your features was added to the project:

We had originally planned to implement save schedule feature but due to the constraints we had due to the fake database
we decided to instead implement the add course feature since this feature only requires us to save the courses at the point 
in time when it is being used.

Provide links to the feature, user stories, and merge requests (if used), associated tests, and merge commit
that was used complete the feature:

Link to the Add schedule Feature: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/25
Link to user story Add schedule: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/26



Use one or two paragraphs which can have point-form within them.

Exceptional code
----------------

Provide a link to a test of exceptional code. In a few sentences,
provide an explanation of why the exception is handled or thrown
in the code you are testing.

Branching
----------

The branching is described inside the readme file and link is provided below

Provide a link to where you describe your branching strategy.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/blob/master/README.md


Link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/network/master


Screenshot of feature inside branching strategy:
![Graph](https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/blob/master/Graph.png)


SOLID
-----

Find a SOLID violation in the project of group `(n%12)+1` (group 12 does group 1).
Open an issue in their project with the violation,
clearly explaining the SOLID violation - specifying the type, provide a link to that issue. Be sure
your links in the issues are to **specific commits** (not to `main`, or `develop` as those will be changed).

Provide a link to the issue you created here.

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
