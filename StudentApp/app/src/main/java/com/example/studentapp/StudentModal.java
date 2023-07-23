package com.example.studentapp;

public class StudentModal {

    int rollNumber ;
    String studentName,studentcollege,studentTread,studentClass;
    float marks;

    public StudentModal(int rollNumber, String studentName, String studentcollege, String studentTread, String studentClass, float marks) {
        this.rollNumber = rollNumber;
        this.studentName = studentName;
        this.studentcollege = studentcollege;
        this.studentTread = studentTread;
        this.studentClass = studentClass;
        this.marks = marks;
    }
}
