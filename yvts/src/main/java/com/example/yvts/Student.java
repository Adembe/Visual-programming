package com.example.yvts;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    private SimpleStringProperty studentID;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;

    public Student(String studentId, String firstName, String lastName) {
        this.studentID = new SimpleStringProperty(studentId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getStudentId() {
        return studentID.get();
    }

    public void setStudentId(String studentId) {
        this.studentID = new SimpleStringProperty(studentId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }
}
