package com.example.coursescheduler.application;

import android.content.Context;

public class Main
{
   // private static Context dbName;
     private static Context dbName;

    public static void main(String[] args)
    {
      //  CLI.run();
        System.out.println("All done");
    }

//    public static void setDBPathName(final String name) {
//        try {
//            Class.forName("org.hsqldb.jdbcDriver").newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        dbName = name;
//    }

    public static Context getDBPathName() {
        return dbName.getApplicationContext();
    }
}
