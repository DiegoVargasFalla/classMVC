package net.classes.ejercicio24.controller;

import net.classes.ejercicio24.model.CourseEntity;
import net.classes.ejercicio24.view.ViewCourse;

public class ControllerCourse {

    private ViewCourse view;
    private CourseEntity course;

    public ControllerCourse(ViewCourse view, CourseEntity course) {
        this.view = view;
        this.course = course;
    }

    public void init() {

        while (view.getRunning()) {
            view.showView();
        }
    }


}
