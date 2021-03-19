Iteration 2 Worksheet
=====================
Paying off technical debt
-----------------
1. 
At Iteration 1 we use fake database to test project. Now we have to use SQL to deal with data. Because Fake database is easier to use and work quick if test. But SQL need more step to test. Such that we still need SQL to serve data, so Fake database is a quick, but messy way

[SQLdatabase](https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/commit/b8b94620a26853584486fc8d1b3c97e512bb02e3#329611760aa3173adbd3b9b5e193926debd33f81_6_6)

2. 

SOLID for A01 group 9
-----
1. 
[Iink to the issue](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-9/-/issues/43)

[Just lead into commit link](https://code.cs.umanitoba.ca/3350-winter-2021-a01/group-9/-/commit/8cd2c753f7f78f3a49ce551163b3e12bb8156dc8#6ec7ae92ccda9a16082b3f9bab8f100191c76d52_133_159)



RETROSPECTIVE
-------------
Overall, the group as a whole has been working really well together to accomplish shared goals. However there are plenty of areas that we can improve
our development process. Therefore, the team communicates well with one another and have good organization of iterations and task. 
One problem that we fixed from iteration 1 is branching, for example having different branches assigned with specific issues along with the designated task. So 
that we can all show our distribution in the project and keep a record of it. For instances, one of the group members opened an issue for refactoring the codes, https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/41
An issue for retrospective was open. https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/42 
All of them are labelled as 'High Priority' and 'To Do' since we all need to work on this right now. The branches and issues help other members to see the progress of the task and provide any help if needed.

We have 3 features implemented for Iteration2.
Feature 1 link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/48
Feature 2 link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/49
Feature 3 link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/50

Fortunately, we are able to get the Database working and able to display 
the Database entries on the UI. https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/44. 

We updated the Architecture after feedback from the professor.
Link to Architecture issue: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/39

Updated the UI in UI branch. The UI was redesigned to have a login Page at start and include a registeration page to create student accounts.
Atfer logging in with a created user account, the user goes to the Main page to see their information and other functionalities such as Update info or delete user account or create new schedule.
Link: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/45

An additional issue from Iteration1 was Time Managemnet. Since all group members had lots of other commitments for different courses. Later on, a rough draft was laid out for group 
members assigned with various task in order to ensure smoother development. 
Another sector that can be improved is having more careful code review for new features later on. 
An important measure of success would be continuing to keep all new merge request small to ensure that they be reviewed properly and less dead code. 
In conclusion, our main concern is to get the app to work first then do the functionality.

Iteration 1 Feedback fixes
--------------------------
Our main issue was that the code was structured wrong (presentation was talking to persistence layer, interface for the database was implemented incorrectly). We created new interface files and refactored how the code is communicating.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/29 (Code Smells)
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/28(DB DIP violation)

Links to Issues that fixed up the code:
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/commit/d17e99fbf9af0a55090b10bbe1495398e207ba54 
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/commit/fcab418c800e24029bbb76491f1cc8f252457a3f


 
   


 
   
