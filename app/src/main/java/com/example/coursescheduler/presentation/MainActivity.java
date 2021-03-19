package com.example.coursescheduler.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.example.coursescheduler.R;
import com.example.coursescheduler.business.AccessStudent;
import com.example.coursescheduler.objects.Student;

public class MainActivity extends AppCompatActivity {

    private Button schedule;
    private Button delete;
    private Button update;
    private Button logout;
    private AccessStudent accessStudent;
    private Student currentStudent;
    private String studentID;
    private String studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        Log.i("myTag", "bundle: "+ b);
        if(b != null) {
            studentID = b.getString("studentID");
            studentName = b.getString("studentName");
        }
        Log.i("myTag", "id: "+ studentID);
        Log.i("myTag", "name: "+ studentName);

        accessStudent = new AccessStudent(this);
        currentStudent = new Student(Integer.parseInt(studentID), studentName);

        try{
            TextView studentIdText = (TextView) findViewById(R.id.studentID_main);
            TextView studentNameText = (TextView) findViewById(R.id.studentName_main);
            studentNameText.setText(studentName);
            studentIdText.setText(studentID);

            delete = findViewById(R.id.deleteBtn_main);
            update = findViewById(R.id.updateBtn_main);
            schedule = findViewById(R.id.scheduleBtn_main);
            logout = findViewById(R.id.logoutBtn_main);

            schedule.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("studentID", Integer.parseInt(studentID));
                    b.putString("studentName", studentName);
                    scheduleIntent.putExtras(b);
                    startActivity(scheduleIntent);
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Deleting Student");
                    deleteStudent();
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Updating Student");
                    updateStudent();
                    Toast.makeText(MainActivity.this, "Update successful", Toast.LENGTH_LONG).show();
                    Log.i("myTag", "Student Updated");
                }
            });

            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("myTag", "Logout Student");
                    logoutStudent();
                    Toast.makeText(MainActivity.this, "Logout successful", Toast.LENGTH_LONG).show();
                    Log.i("myTag", "Student logged out");
                }
            });

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void deleteStudent(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Toast.makeText(MainActivity.this, "Delete successful", Toast.LENGTH_LONG).show();
        Log.i("myTag", "Starting Delete function");
        accessStudent.deleteStudent(currentStudent);
        Log.i("myTag", "Delete successful");
        startActivity(intent);
    }

    protected void logoutStudent(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        Toast.makeText(MainActivity.this, "Logout successful", Toast.LENGTH_LONG).show();
        Log.i("myTag", "Starting Logout function");
        Log.i("myTag", "Logout successful");
        startActivity(intent);
    }

    protected void updateStudent() {
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        Log.i("myTag", "Starting Delete function");
        accessStudent.updateStudent(currentStudent);
        Log.i("myTag", "Update successful");
        startActivity(intent);
    }
}

//    private AccessStudent accessStudent;
//    private List<Student> studentList;
//    private ArrayAdapter<Student> studentArrayAdapter;
//
//    private int selectedStudentPos = -1;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        //Database.initData(); //initialize the database and initializes up the ArrayList list in Database
//        accessStudent = new AccessStudent();
//
//        try {
//            studentList = new ArrayList<>();
//            studentList.addAll(accessStudent.getStudentSequential());
//            studentArrayAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_activated_2, android.R.id.text1, studentList) {
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    View view = super.getView(position, convertView, parent);
//                    TextView text1 = (TextView) view.findViewById(android.R.id.text1);
//                    text1.setText(studentList.get(position).getStudentName());
//                    return view;
//                }
//            };
//
//            final ListView listView = (ListView) findViewById(R.id.listViewStudent);
//            listView.setAdapter(studentArrayAdapter);
//
//            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    if (position == selectedStudentPos) {
//                        listView.setItemChecked(position, false);
//                        selectedStudentPos = -1;
//                    } else {
//                        listView.setItemChecked(position, true);
//                        selectedStudentPos = position;
//                        selectStudentAtPosition(position); //calls the method to set the current student in database
//                        Intent scheduleIntent = new Intent(MainActivity.this, ScheduleActivity.class); //Goes to ScheduleActivity Page
//                        startActivity(scheduleIntent);
//                    }
//                }
//            });
//        } catch (final Exception e) {
//            System.out.println(e);
//        }
//    }
//
//    public void selectStudentAtPosition(int position) {
//        Student selected = studentArrayAdapter.getItem(position);
//        accessStudent.setCurrentStudent(selected);
//
//        TextView studentID = (TextView)findViewById(R.id.textStudentID);
//        TextView studentName = (TextView)findViewById(R.id.textStudentName);
//
//        studentID.setText("Student ID: "+ selected.getStudentName());
//        studentName.setText("Student Name: "+ selected.getStudentID());
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//    }
