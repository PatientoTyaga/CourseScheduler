Architecture descriptions

We are using the 3 layer system of  user UI(presentation), Logic(Business) and  Database(persistence).  And a  object  layer to support type 

*Object Layers*： include object class: Course, student, Schedule which dependency on first two object. Support object type for 3 layers

*Presentation Layers*：use main MainActivity  with the other classes:  LoginActivity,  CourseActivity,  ScheduleActivity,ect
This layer handles any and all UI Activity. There are all use android activities use android.app.Activity and may cause technical debt.


*Logic Layers*: AccessCourse, AccessStudent,AccessSchedule：Access Data Layers for each type of object. And  proves Use for service layer tests.
This layer proves the method on how to contain logic, when to load data from Data Layers and how to input data into Data Layers.
It acts as a "transit layer" between the UI and the database layer, providing method that we can use to interact with the database.
It not only can transfer the database into instance and show in UI if needeed. But also transfer UI input instance to update database.

Validator and ValidatorCourse are classes that take care of validation. Validator makes sure that the student entries such as name and student ids are being added correctly,
making sure that invalid characters aren't being added. ValidatorCourse takes care of validation for course where it checks for timeconflict in courses and making sure
a course isn't added twice.


*Data Layers (Persistence)*:	
IDatabase: Able to display object list on MainActivity from the HSQLdatabase.
ISchedule: Able to display Schedule Object list on ScheduleActivity from HSQLdatabase.
Database Layer: It implements methods of IDatabase and ISchedule which access HSQLdatabase data
This layer prove method about how to access Database.  It use a interface to  isolation the Database 's  private  part and avoid call by mistake .
In Sql Database we have "Course" "Schedule" "Student"  tables to help store data and use tablenamePersistence to work on them.
