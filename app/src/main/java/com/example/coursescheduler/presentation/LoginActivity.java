package com.example.coursescheduler.presentation;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.database.DatabaseHelper;
import com.example.coursescheduler.objects.Course;
import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IDatabase;
import com.example.coursescheduler.persistence.IStudentPersistence;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistence;
import com.example.coursescheduler.persistence.hsqldb.StudentPersistenceHSQLDB;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {


    StudentPersistence myDb;
    EditText studentName;
    EditText studentID;
    TextView text_view;
    Button btnadd;
    Button btnload;
    Button btnfind;
    Button btndelete;
    Button btnupdate;

    /*
    private AccessStudent accessStudents;
    private List<Student> studentList;
    private ArrayAdapter<Student> studentArrayAdapter;

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        studentName = (EditText) findViewById(R.id.studentname);
        studentID = (EditText)findViewById(R.id.studentid);
        text_view = (TextView) findViewById(R.id.text_view);
        btnadd = (Button)findViewById(R.id.btnadd);
        btndelete = (Button)findViewById(R.id.btndelete);
        btnupdate = (Button)findViewById(R.id.btnupdate);
        btnload = (Button)findViewById(R.id.btnload);
        btnfind = (Button)findViewById(R.id.btnfind);

        /*
        accessStudents = new AccessStudent();

        try {
            studentList = new ArrayList<>();
            studentList.addAll(accessStudents.getStudentSequential());
            studentArrayAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, studentList) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);

                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);

                    text1.setText(studentList.get(position).getStudentID() + ": " + studentList.get(position).getStudentName());

                    return view;
                }
            };

        }catch (final Exception e)
        {
            Messages.fatalError(this, e.getMessage());
        }





        myDb = new StudentPersistence(this); //calls constructor of DabaseHelper which creates Db and table
        editName = (EditText) findViewById(R.id.editText_name);
        editID = (EditText)findViewById(R.id.editText_id);
        btnAddData = (Button)findViewById(R.id.button_add);



        boolean insertCoursesA = myDb.insertCourseData("1010", "Intro Computer Science", "08:30-09:30","TR");
        boolean insertCoursesB = myDb.insertCourseData("2080", "Analysis of Algorithms", "10:30-11:30","TR");
        boolean insertCoursesC = myDb.insertCourseData("2150", "Object Orientation", "10:30-11:30","MWF");
        boolean insertCoursesD = myDb.insertCourseData("3020", "Human-Computer Interaction 1", "11:20-12:30","TR");


        showData();

         */


    }

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

    public void loadStudents(View view){
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
            + System.getProperty("line")));
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
}
