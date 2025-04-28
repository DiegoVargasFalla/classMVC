package net.classes.ejercicio24.view;

import java.util.Scanner;

public class ViewCourse {

    private String consoleMessage;
    private Scanner scanner;
    private Boolean running;

    public ViewCourse() {
        scanner = new Scanner(System.in);
        consoleMessage = "";
        running = true;
    }

    public void showView() {
        consoleMessage = "------- Menu -------";
        System.out.println(consoleMessage);

        consoleMessage = "1) Crear un estudiante";
        System.out.println(consoleMessage);

        consoleMessage = "2) Eliminar un estudiante";
        System.out.println(consoleMessage);

        consoleMessage = "3) Buscar un estudiante";
        System.out.println(consoleMessage);

        consoleMessage = "4) Modificar un estudiante";
        System.out.println(consoleMessage);

        consoleMessage = "5) Calcular promedio curso";
        System.out.println(consoleMessage);

        consoleMessage = "6) Alumnos aprovados";
        System.out.println(consoleMessage);

        consoleMessage = "7) Ver estudiantes";
        System.out.println(consoleMessage);

        consoleMessage = "8) salir";
        System.out.println(consoleMessage);

        consoleMessage = " -> ";
        System.out.print(consoleMessage);
    }

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }
}
