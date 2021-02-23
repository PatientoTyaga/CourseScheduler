package com.example.coursescheduler.Database;

public class Database {
    public static String [] timeArea ={
            "08:30-09:30",
            "10:30-11:20",
            "11:20-12:30",
            "13:30-14:20"
    };
    //10 test students Info
    public static String [][] studentInfo = {
            { "Simrandeep", "7784215" },
            { "Mohammad", "7853346" },
            { "Rusty", "7850109"},
            {"Alan","7840761"},
            {"Verne","7841354"},
            {"Rudolf", "7854451"},
            {"Norman","7843879"},
            {"Shirley","7846612"},
            {"Mamie","7841106"},
            {"Lucy","7849975"},
            {"Jill","7847416"}
    };
    //10 test course Info
    public static String [][] courseInfo = {
            { "Comp1010", "Intro Computer Science 1", timeArea[0], "TR" },
            { "Comp2080", "Analysis of Algorithms", timeArea[1], "MWF" },
            { "Comp2150", "Object Orientation", timeArea[1], "MWF"},
            { "Comp3020", "Human-Computer Interaction 1", timeArea[2], "TR" },
            { "Comp3040", "Technical Communication", timeArea[1], "TR" },
            { "Comp3350", "Software Engineering 1", timeArea[2], "MWF"},
            { "Comp4380", "Database Implementation", timeArea[0], "TR" },
            { "Stat2000", "Basic Statistical Analysis 2", timeArea[3], "MWF"},
            { "Econ2010", "MicroEconomics Theory 1", timeArea[1], "TR"},
            { "Econ2020", "MacroEconomics Theory 1", timeArea[1], "TR"}
    };

}
