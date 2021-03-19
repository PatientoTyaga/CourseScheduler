package com.example.coursescheduler.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.objects.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;


public class LoginActivity extends AppCompatActivity {

//    StudentPersistence myDb;
//    EditText studentName;
//    EditText studentID;
//    TextView text_view;
//    Button btnadd;
//    Button btnload;
//    Button btnfind;
//    Button btndelete;
//    Button btnupdate;

    private AccessStudent accessStudents;
    private List<Student> studentList;
    private Student currentStudent;
    private EditText studentID;
    private EditText studentName;
    private Button registerStudentBtn;
    private Button loginStudentBtn;
    private String msg;
    private boolean match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accessStudents = new AccessStudent(this);
        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());
            studentID = findViewById(R.id.studentID_login);
            studentName = findViewById(R.id.studentName_login);
            registerStudentBtn = findViewById(R.id.registerBtn_login);
            loginStudentBtn = findViewById(R.id.loginBtn_login);

            registerStudentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    registerStudent();
                }
            });

            loginStudentBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(studentID.getText().toString() != null && studentName.toString() != null){
                        loginStudent();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerStudent(){
        // Goes to Student Register form on register button click
        Intent scheduleIntent = new Intent(LoginActivity.this, RegisterActivity.class); //Goes to ScheduleActivity Page
        startActivity(scheduleIntent);
    }

    protected boolean validate(){
        for(Student s: studentList){
            Log.i("myTag", s.getStudentName() + ", " + s.getStudentID());
            if(s.getStudentID() == Integer.parseInt(studentID.getText().toString()) && s.getStudentName().matches(studentName.getText().toString())){
                Log.i("myTag", s.getStudentName() + " reached");
                return true;
            }
            else{
                continue;
            }
        }
        return false;
    }

    public void loginStudent(){
        // checks for the student inside the list of students from database
        if(validate()){
            Log.i("myTag", "login function reached");
            Student student = new Student(Integer.parseInt(studentID.getText().toString()), studentName.getText().toString());
            currentStudent = accessStudents.fetchStudent(student);

            msg = "Redirecting to Main Page!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            Intent scheduleIntent = new Intent(this, MainActivity.class); //Goes to ScheduleActivity Page
            scheduleIntent.putExtra("studentID", studentID.getText().toString());
            scheduleIntent.putExtra("studentName", studentName.getText().toString());
            studentID.setText("");
            studentName.setText("");
            startActivity(scheduleIntent);
        }
        else if(!validate()){
            msg = "User not found, please check credentials or register";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            studentID.setText("");
            studentName.setText("");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    //        studentName = (EditText) findViewById(R.id.studentname);
//        studentID = (EditText)findViewById(R.id.studentid);
//        text_view = (TextView) findViewById(R.id.text_view);
//        btnadd = (Button)findViewById(R.id.btnadd);
//        btndelete = (Button)findViewById(R.id.btndelete);
//        btnupdate = (Button)findViewById(R.id.btnupdate);
//        btnload = (Button)findViewById(R.id.btnload);
//        btnfind = (Button)findViewById(R.id.btnfind);
//        btnload.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(intent);
//            }
//        });




//            studentArrayAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, studentList) {
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//
//                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
//
//                    text1.setText(studentList.get(position).getStudentID() + ": " + studentList.get(position).getStudentName());
//
//                    return view;
//                }
//            };

//        }catch (final Exception e)
//        {
//            Messages.fatalError(this, e.getMessage());
//        }
//
//
//
//
//
//        myDb = new StudentPersistence(this); //calls constructor of DabaseHelper which creates Db and table
//        editName = (EditText) findViewById(R.id.editText_name);
//        editID = (EditText)findViewById(R.id.editText_id);
//        btnAddData = (Button)findViewById(R.id.button_add);
//
//
//
//        boolean insertCoursesA = myDb.insertCourseData("1010", "Intro Computer Science", "08:30-09:30","TR");
//        boolean insertCoursesB = myDb.insertCourseData("2080", "Analysis of Algorithms", "10:30-11:30","TR");
//        boolean insertCoursesC = myDb.insertCourseData("2150", "Object Orientation", "10:30-11:30","MWF");
//        boolean insertCoursesD = myDb.insertCourseData("3020", "Human-Computer Interaction 1", "11:20-12:30","TR");
//
//
//        showData();
//
//         */
//
//
//    }

    /*
    public void showData(){

        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertStudentData(editID.getText().toString(),
                                editName.getText().toString());

                        if(isInserted){
                            Toast.makeText(getApplicationContext(), "Data Inserted", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Data not Inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

     */

   /* public void loadStudents(View view){
        StudentPersistence studentPersistence = new StudentPersistence(this);
        text_view.setText(studentPersistence.loadHandler());
        studentName.setText("");
        studentID.setText("");
    }

    public void addStudent(View view){
        StudentPersistence studentPersistence = new StudentPersistence(this);
        int id = Integer.parseInt(studentID.getText().toString());
        String name = studentName.getText().toString();
        Student student = new Student(id,name);
        studentPersistence.addHandler(student);
        studentID.setText("");
        studentName.setText("");
    }

    public void findStudent(View view){
        StudentPersistence studentPersistence = new StudentPersistence(this);
        Student student = studentPersistence.findHandler(studentName.getText().toString());
        if(student != null){
            text_view.setText(String.valueOf(student.getStudentID() + " " + student.getStudentName()
            + System.getProperty("line.separator")));
            studentID.setText("");
            studentName.setText("");
        }else{
            text_view.setText("No Match Found");
            studentID.setText("");
            studentName.setText("");
        }
    }

    public void removeStudent(View view) {
        StudentPersistence studentPersistence = new StudentPersistence(this);

        boolean result = studentPersistence.deleteHandler(Integer.parseInt(
                studentID.getText().toString()));
        if (result) {
            studentID.setText("");
            studentName.setText("");
            text_view.setText("Record Deleted");
        } else
            studentID.setText("No Match Found");
    }

    public void updateStudent(View view) {
        StudentPersistence studentPersistence = new StudentPersistence(this);
        boolean result = studentPersistence.updateHandler(Integer.parseInt(
                studentID.getText().toString()), studentName.getText().toString());
        if (result) {
            studentID.setText("");
            studentName.setText("");
            text_view.setText("Record Updated");
        } else
            studentID.setText("No Match Found");
    }

    */



}
