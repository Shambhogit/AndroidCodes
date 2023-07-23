package com.example.studentapp;

public class DataModal {
    String name,className,tread,college;
    int unique,roll;
    float marks;
    public DataModal(int unique,int roll,String name, String className, String tread,String college,float marks){
        this.unique = unique;
        this.roll = roll;
        this.name = name;
        this.className = className;
        this.tread = tread;
        this.college = college;
        this.marks = marks;
    }
}
