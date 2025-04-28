package net.classes.classesUni.view;

import java.util.Scanner;

public class CompanyView {

    private String consoleMessage;
    Scanner field;
    boolean running;

    //option
    int option;

    // company class inputs
    String companyNameInput;
    Long companyIdInput;

    // person class inputs
    Long personIdInput;
    String personNameInput;
    String personSurnameInput;
    int personAgeInput;

    public CompanyView() {
        //input field
        field = new Scanner(System.in);
        running = true;

        // start company variable
        consoleMessage = "";
        companyNameInput = "";
        companyIdInput = 0L;

        //start company variable
        personIdInput = 0L;
        personNameInput = "";
        personSurnameInput = "";
        personAgeInput = 0;
    }

    public void showView() {
        consoleMessage = "\n##### Bienvenido  #####";
        System.out.println(consoleMessage);

        consoleMessage = "-------- Menu --------\n";
        System.out.println(consoleMessage);

        consoleMessage = "| Ingrese una opción |";
        System.out.println("----------------------");
        System.out.println(consoleMessage);
        System.out.println("----------------------");
        consoleMessage = "  1) Ingresar compañia";
        System.out.println(consoleMessage);
        consoleMessage = "  2) Ingresar trabajador";
        System.out.println(consoleMessage);
        consoleMessage = "  3) ver informacion";
        System.out.println(consoleMessage);
        consoleMessage = "  0) Salir";
        System.out.println(consoleMessage);

        consoleMessage = " -> ";
        System.out.print(consoleMessage);
    }

    public boolean getRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getConsoleMessage() {
        return consoleMessage;
    }

    public Scanner getScanner() {
        return field;
    }

    public void setScanner(Scanner field) {
        this.field = field;
    }

    public void setConsoleMessage(String consoleMessage) {
        this.consoleMessage = consoleMessage;
    }

    public String getCompanyNameInput() {
        return companyNameInput;
    }

    public void setCompanyNameInput(String companyNameInput) {
        this.companyNameInput = companyNameInput;
    }

    public Long getCompanyIdInput() {
        return companyIdInput;
    }

    public void setCompanyIdInput(Long companyIdInput) {
        this.companyIdInput = companyIdInput;
    }

    public Long getPersonIdInput() {
        return personIdInput;
    }

    public void setPersonIdInput(Long personIdInput) {
        this.personIdInput = personIdInput;
    }

    public String getPersonNameInput() {
        return personNameInput;
    }

    public void setPersonNameInput(String personNameInput) {
        this.personNameInput = personNameInput;
    }

    public String getPersonSurnameInput() {
        return personSurnameInput;
    }

    public void setPersonSurnameInput(String personSurnameInput) {
        this.personSurnameInput = personSurnameInput;
    }

    public int getPersonAgeInput() {
        return personAgeInput;
    }

    public void setPersonAgeInput(int personAgeInput) {
        this.personAgeInput = personAgeInput;
    }
}
