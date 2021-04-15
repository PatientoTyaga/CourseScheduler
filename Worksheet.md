1. What technical debt has been cleaned up? Show links to a commit where you paid off technical debt. Write 2-5 sentences that explain what debt was paid, and what its classification is.
    * For technical debt we had testing and database. Both were prudent debts. We didn’t get time to write tests for our iteration 2, but we knew that for next iteration we would have to do testing for old and new code. We decided that adding another feature was more important at that moment. As for database, initially we wanted to implement functionality about adding courses, but our database was creating only students table. So, because of that we had to change what features we will deliver for iteration 2, just so we will have something working and worry about the database in the next iteration.


2. What technical debt did you leave? What one item would you like to fix, and can't? Anything you write will not be marked negatively. Classify this debt.
    * Technical debt for the project: OCP violation https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/71 , but we won’t be able to fix it because to add a new button we would have to change SO much code in this file. We are sure there is a way around it with lists and ENUMs so we could avoid having to modify code in so many places just to add or remove a button.  


3. Discuss a Feature or User Story that was cut/re-prioritized. When did you change the priority of a Feature or User Story? Why was it re-prioritized? Provide a link to the Feature or User Story. This can be from any iteration.
    * We had to cut quite a few features. We had some ideas involving a calendar like show due dates for assignments for the courses student is registered in, add your own remainders in the calendar. Also attach images or text to the courses you registered in. Share your schedule with someone. Due to time constraints we had to abandon the idea of implementing those features at the end of iteration 2.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/3
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/17
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/23
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/12

4. Acceptance test/end-to-end. Write a discussion about an end-to-end test that you wrote. What did you test, how did you set up the test so it was not flaky? Provide a link to that test.
    * The acceptance test, tested all the major features that are provided in the app. These are:
    - Register Student https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/48
    - Login Student https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/45
    - Create Schedule https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/1
    - Add Course https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/25
    - Delete Course https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/4
    - Resolve Schedule Conflict https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/5
    - Update Student https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/50
    - Delete Student https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/issues/49
    
    Link to Test: https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/tree/develop/app/src/androidTest/java/com/example/coursescheduler/presentation
     
    The test was created using the "Run Espresso Test" feature in Android Studio. This allowed us to run the tests on the GUI. And once the GUI based test was complete, the inputs were converted into code for AccpetanceTest.java


5. Acceptance test, untestable. What challenges did you face when creating acceptance tests? What was difficult or impossible to test?
    
    For writing acceptance tests, there were no particular difficulties to test the different features in the app. The only change I had to make to the Espresso Test was to replace the AndroidJUnit.class with the latest version. 
    For the feature that was impossible to test was adding course to the database. Since the app will add a list of pre defined courses to the database. This is something that we cannot test via Acceptance Test, since there is no ability to test this feature through the GUI.


6. Velocity/teamwork. Did your estimates get better or worse through the course? Show some evidence of the estimates/actuals from tasks.
    
    The team had better estimates as we progressed through our project. During the initial iteration of the project, we estimated higher and we were only able todeliver half of it. 
    During Iteration 2, we had multiple bugs and technical debt that we had to resolve. Therefore the features that were estimated for iteration 2 were not met. 
    In the development process of Iteration 3 we were able to resolve almost all of the technical debts and bugs. We were also able to add new features to the app that we had estimated.
    Due to the limited time constraints, we were not able to deliver some other features such as representing the schedule in a calendar format and thus any other features relating to it were moved to future development.
    Througout the project, our estimation have gotten better as can be observed in the graph below.

![](Course_Schedule_Velocity.png)
