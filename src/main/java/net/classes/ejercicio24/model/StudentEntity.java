package net.classes.ejercicio24.model;

public class StudentEntity {
    private Long id;
    private String name;
    private String surname;
    private int semester;
    private Float note;

    public StudentEntity(Long id, String name, String surname, int semester, Float note) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.semester = semester;
        this.note = note;
    }

    public StudentEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void showInfo() {
        System.out.println("+------------------+");
        System.out.println("| id: " + id);
        System.out.println("| nombre: " + name);
        System.out.println("| apellido: " + surname);
        System.out.println("| semestre: " + semester);
        System.out.println("| nota: " + note);
    }
}
