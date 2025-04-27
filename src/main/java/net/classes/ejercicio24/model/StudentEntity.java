package net.classes.ejercicio24.model;

public class StudentEntity {
    private int id;
    private String name;
    private String surname;
    private int semester;
    private Float note;

    public StudentEntity(int id, String name, String surname, int semester, Float note) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.semester = semester;
        this.note = note;
    }

    public StudentEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }
}
