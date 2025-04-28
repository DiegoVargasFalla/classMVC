package net.classes;

import net.classes.ejercicio24.controller.ControllerCourse;
import net.classes.ejercicio24.model.CourseEntity;
import net.classes.ejercicio24.view.ViewCourse;

public class Main {



    public static void main(String[] args) {
        /*
        Se tiene un curso universitario el cual contiene una lista de estudiantes.
        Para cada estudiante se tienen los datos: nombre y apellidos del
        estudiante, código, número de semestre y nota final del estudiante.
        Se requiere implementar los siguientes métodos:
        Añadir un estudiante al curso: se ingresan por teclado los datos
        del estudiante. El código del estudiante debe ser único,
        si el código ya existe se debe generar el mensaje correspondiente.
        Buscar un estudiante de acuerdo con su código ingresado
         */

        ViewCourse view = new ViewCourse();
        CourseEntity course = new CourseEntity();

        ControllerCourse controller = new ControllerCourse(view, course);
        controller.init();



























//        //company view
//        CompanyView companyView = new CompanyView();
//
//        //company object
//        CompanyEntity company = new CompanyEntity();
//
//        ArrayList<CompanyEntity> listCompany = new ArrayList<>();
//
//        //company controller
//        CompanyController controller = new CompanyController(companyView, company, listCompany);
//
//        //show view
//        controller.init();
    }
}