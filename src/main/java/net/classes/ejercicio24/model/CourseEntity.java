package net.classes.ejercicio24.model;

import java.util.ArrayList;

public class CourseEntity {
    private int id;
    private String nameCourse;
    private ArrayList<StudentEntity> studentsList;

    public CourseEntity(int id, String nameCourse, ArrayList<StudentEntity> studentsList) {
        this.id = id;
        this.nameCourse = nameCourse;
        this.studentsList = studentsList;
    }

    public CourseEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public ArrayList<StudentEntity> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<StudentEntity> studentsList) {
        this.studentsList = studentsList;
    }
}
