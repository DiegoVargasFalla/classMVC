package net.classes.ejercicio24.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.classes.ejercicio24.model.CourseEntity;
import net.classes.ejercicio24.model.StudentEntity;
import net.classes.ejercicio24.view.ViewCourse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ControllerCourse {

    private ViewCourse view;
    private CourseEntity course;

    public ControllerCourse(ViewCourse view, CourseEntity course) {
        this.view = view;
        this.course = course;
    }

    public void init() {

        while (view.getRunning()) {

            ArrayList<StudentEntity> studentsList = getInfoFile();
            course.setStudentsList(studentsList);

            view.showView();
            Scanner scanner = view.getScanner();

            int option = scanner.nextInt();

            if (option == 1) {
                createStudent();
            } else if (option == 2) {

                scanner.nextLine();
                showInfo();
                view.setConsoleMessage(" \n####Ingrese el id del estudiante a eliminar####");
                System.out.println(view.getConsoleMessage());

                view.setConsoleMessage(" -> ");
                System.out.print(view.getConsoleMessage());
                Long id = scanner.nextLong();
                deleteStudent(id, course.getStudentsList());

            } else if (option == 7) {
                showInfo();
            } else if (option == 3) {
                view.setConsoleMessage(" Ingrese el id a buscar");
                System.out.println(view.getConsoleMessage());
                scanner.nextLine();
                Long id = scanner.nextLong();
                searchStudent(id, course.getStudentsList());
            }

        }
    }

    public void createStudent() {
        Scanner scanner = view.getScanner();

        view.setConsoleMessage("+ Ingrese el id del estudiante");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        Long id = scanner.nextLong();
        scanner.nextLine();


        while (checkId(id, course)) {
            view.setConsoleMessage(" ¡¡este id ya existe!!");
            System.out.println(view.getConsoleMessage());

            view.setConsoleMessage("+ Ingrese el id de nuevo");
            System.out.println(view.getConsoleMessage());
            view.setConsoleMessage(" -> ");
            System.out.print(view.getConsoleMessage());

            id = scanner.nextLong();
            scanner.nextLine();
        }


        view.setConsoleMessage("+ Ingrese el nombre del estudiante");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        String name = scanner.nextLine();

        view.setConsoleMessage("+ Ingrese el apellido del estudiante");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        String surname = scanner.nextLine();

        view.setConsoleMessage("+ Ingrese el semestre del estudiante");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        int semestre = scanner.nextInt();
        scanner.nextLine();

        Float note = 0F;

        StudentEntity student = new StudentEntity(id, name, surname, semestre, note);
        course.getStudentsList().add(student);
        System.out.println(course.getStudentsList());

        saveInfoFile(course.getStudentsList());
    }

    public Boolean checkId(Long id, CourseEntity course) {

        ArrayList<StudentEntity> studentList = course.getStudentsList();

        if (studentList != null) {

            for (StudentEntity student : studentList) {
                if (student.getId() == id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    // aqui
    public void saveInfoFile(ArrayList<StudentEntity> studentList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/net/classes/ejercicio24/info2.json"), studentList);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<StudentEntity> getInfoFile() {
        ArrayList<StudentEntity> studentList;
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            studentList = mapper.readValue(new File("src/main/java/net/classes/ejercicio24/info2.json"), new TypeReference<>() {});
            return studentList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return new ArrayList<>();
    }

    public void showInfo() {
        ArrayList<StudentEntity> studentList = course.getStudentsList();
        System.out.println("######Lista de estudiantes#######\n");

        for (StudentEntity student : studentList) {
            student.showInfo();
        }
    }

    public void  searchStudent(Long id, ArrayList<StudentEntity> studentList) {
        for (StudentEntity student : studentList) {
            if (student.getId() == id) {
                student.showInfo();
            }
        }
        System.out.println("No existe el estudiante con id " + id);
    }

    public void deleteStudent(Long id, ArrayList<StudentEntity> studentList) {
        for (StudentEntity student : studentList) {
            if (student.getId().equals(id)) {
                studentList.remove(student);
                saveInfoFile(studentList);
                view.setConsoleMessage("- Estudiante eliminado");
                System.out.println(view.getConsoleMessage());
                return;
            }
        }
        System.out.println("No existe el estudiante con id " + id);
    }
}
