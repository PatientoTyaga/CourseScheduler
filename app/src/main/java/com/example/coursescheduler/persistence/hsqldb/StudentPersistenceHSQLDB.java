package com.example.coursescheduler.persistence.hsqldb;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.coursescheduler.objects.Student;
import com.example.coursescheduler.persistence.IStudentPersistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentPersistenceHSQLDB implements IStudentPersistence {

    private final String dbPath;

    public StudentPersistenceHSQLDB(final String dbPath) {
        this.dbPath = dbPath;
    }

    private Connection connection() throws SQLException {
        return DriverManager.getConnection("jdbc:hsqldb:file:" + dbPath + ";shutdown=true", "SA", "");
    }

    private Student fromResultSet(final ResultSet rs) throws SQLException {
        final String studentID = rs.getString("studentID");
        final String studentName = rs.getString("name");

        return new Student(studentID,studentName);
    }

    @Override
    public List<Student> getStudentSequential() {
        final List<Student> students = new ArrayList<>();
        try (final Connection c = connection()) {
            final Statement st = c.createStatement();
            final ResultSet rs = st.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                final Student student = fromResultSet(rs);
                students.add(student);
            }
            rs.close();
            st.close();

            return students;
        } catch (final SQLException e) {
            throw new PersistenceException(e);
        }
    }

}