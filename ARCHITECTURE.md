Architecture descriptions


We are using the 3 layer system of  user UI(presentation), Logic(Business) and  Database(persistence).  And a  object  layer to support type 


*Object Layers*： include object class: Course, student, Schedule which dependency on first two object. Support object type for 3 layers

*Presentation Layers*：use main MainActivity  with the other classes:  LoginActivity,  CourseActivity,  ScheduleActivity,ect
This layer handles any and all UI Activity. There are all use android activities use android.app.Activity and may cause technical debt.


*Logic Layers*: AccessCourse, AccessStudent,AccessSchedule：Access Data Layers for each type of object. And  prove Use for service layer tests.
This layer prove method about how to contains logic. About when laod the data from Data Layers and how to input dat into Data Layers.
It acts as a "transit layer" between the UI and the database layer, providing method that we can use to interact with the database.
It not only can transfer the database into instance and shoing in UI if it need. But also transfer UI input instance to update database.


*Data Layers (Persistence)*:	IDatabase: Able to display object list on MainActivity from the HSQLdatabase.
Database: the implement of IDatabase method which access HSQLdatabase data
This layer prove method about how to access Database.  It use a interface to  isolation the Database 's  private  part and avoid call by mistake .
In SQl Database we have "Course" "Schedule" "Student"  tables. To help storing data. Use tablenamePersistence to work on them.
