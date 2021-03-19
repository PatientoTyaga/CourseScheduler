*Architecture descriptions*


We are using the 3 layer system of  user UI(presentation), Logic(Business) and  Database(persistence).  And a  object  layer to support type 


*Object Layers*： include object class: Course, student, Schedule which dependency on first two object. Support object type for 3 layers

*Presentation Layers*：use main MainActivity  with the other classes:  LoginActivity,  CourseActivity,  ScheduleActivity,ect

*Logic Layers*: AccessCourse, AccessStudent,AccessSchedule：Access Data Layers for each type of object. And  prove Use for service layer tests.

*Data Layers
(Persistence)*
:
	IDatabase: Able to display object list on MainActivity from the HSQLdatabase.
	Database: the implement of IDatabase method which access HSQLdatabase data
This layer prove method about how to access Database.  It use a interface to  isolation the Database 's  private  part and avoid call by mistake .
In SQl Database we have "Course" "Schedule" "Student"  tables. To help storing data.
