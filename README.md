# Course Scheduler

Course scheduler is an app designed to simplify course selection and registering process for University of Manitoba students.
The app allows the user to create schedules with different courses and gives an opportunity to decide what schedule a student will prefer more for their fall and winter terms.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Install Android Studio, and install Git to clone the repository.
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Install Android Studio and install Git to clone the repository.

 * Open Gitlab.
 * Clone the project on your machine, switch to master, do a pull. Open Android Studio, when you select the device to run the application make sure that API 24 or above(Any modern device). Click “build” and then “run”. Android Studio will automatically download any required packages to run the application. 
In the application go to “register”, then enter your first name(letters only) in the first field and your student id in the second field(7 digits only). Click on “Register Student” button. Now enter the credentials that you used during registering process and click on the “login” button.
To add courses to your schedule click on “Open Schedule Page” then “Add Schedule”. Click on a course that you want to add from the list provided and then on a “add course” button in the bottom right corner. And repeat this process for all courses that you want to add to your schedule.
If you try to add courses that start at the same time or overlap with each other the app will notify you about the courses that conflict.  After you done, you can go back to the main page with “back” button and then click on “logout”.
If you want to edit your profile information click on “Edit” button on the main page, then you can type your new name and click on “update student” or if you want you can delete this account with “delete student” button. 
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9

```

## Running the tests

In android studio, next to the “build” button select from the dropdown menu what kind of test you want to run(AllUnitTest, All_IT_Test, AcceptanceTest) and click “run”



## Built With

* [Robolecrtic](http://robolectric.org/) - Used for integration testing
* [Maven](https://maven.apache.org/) - Dependency Management
* [Espresso](https://developer.android.com/training/testing/espresso) - Used for acceptance test


# Branching Strategy
We used gitlab for versioning. 
Create own Branch and merge them togther helps us working as a team.
Branching strategy help the development team move forward quickly. It can coordinate parallel development, allowing developers to work on tasks simultaneously as part of a team.
Parallel building and testing ensure that developers get the feedback they need quickly.
But with the growth of projects and teams, working in parallel become more complex. Because it's not only about merging change files in the team, but also the complex code need merging by people.
Because code may have conflict.
The “merge early and often” strategy helps us fix the merge problem at start.
https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/branches

### Important Links

* Architecture diagram https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/blob/develop/ARCHITECTURE.pdf  
* Architecture description https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/blob/develop/ARCHITECTURE.md
* Vision Statement https://code.cs.umanitoba.ca/3350-winter-2021-a03/coursescheduler-comp3350-a03-group9/-/blob/develop/VISION.md

## Authors

| Member Name | Student Number |
| ------ | ------ |
| Simrandeep Sappal | 7784215 |
| Jianzhi Wang | 7840671|
| Ruslan Yanyshyn| 7850109 |
| Guannan zhu | 7834178 |
| Mohammad Inan | 7853346 |
| Patient Ndayizeye | 7795261 |
