package net.classes.classesUni.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.classes.classesUni.model.CompanyEntity;
import net.classes.classesUni.model.PersonEntity;
import net.classes.classesUni.view.CompanyView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CompanyController {
    CompanyView view;
    CompanyEntity company;
    ArrayList<CompanyEntity> companyList;

    public CompanyController(CompanyView view, CompanyEntity company, ArrayList<CompanyEntity> companyList) {
        this.view = view;
        this.company = company;
        this.companyList = companyList;
    }

    public void init() {

        while (view.getRunning()) {

            view.showView();
            updateList();
            Scanner scanner = view.getScanner();

            try {
                int option = scanner.nextInt();

                if (option == 1) {
                    addCompany();
                    //showInfoCompany();
                } else if (option == 2) {
                    showInfoCompany();
                    addPersonToCompany();
                } else if (option == 3) {
                    showInfoCompany();
                }
                else if (option == 0) {
                    view.setRunning(false);
                }
            } catch (InputMismatchException e) {
                view.setConsoleMessage("\n¡¡¡Ingrese una opcion valida PELOTUUUUUUU!!");
                System.out.println(view.getConsoleMessage());
                scanner.nextLine();
            }
        }

    }

    public void addCompany() {
        Scanner scanner = view.getScanner();
        ArrayList<PersonEntity> personList = new ArrayList<>();

        view.setConsoleMessage("  Ingrese el id de la empresa ");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        Long idCompany = scanner.nextLong();
        scanner.nextLine();

        view.setConsoleMessage("  Ingrese el nombre de la empresa");
        System.out.println(view.getConsoleMessage());
        view.setConsoleMessage(" -> ");
        System.out.print(view.getConsoleMessage());
        String nameCompany  = scanner.nextLine();


        boolean run = true;
        while (run) {
            view.setConsoleMessage("- ¿Desea agregar personas a la empresa?");
            System.out.println(view.getConsoleMessage());
            view.setConsoleMessage(" 1) Si");
            System.out.println(view.getConsoleMessage());
            view.setConsoleMessage(" 2) No");
            System.out.println(view.getConsoleMessage());
            view.setConsoleMessage(" -> ");
            System.out.print(view.getConsoleMessage());
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {

                view.setConsoleMessage("  Ingrese el id de la persona");
                System.out.println(view.getConsoleMessage());
                view.setConsoleMessage(" -> ");
                System.out.print(view.getConsoleMessage());
                Long idPerson = scanner.nextLong();
                scanner.nextLine();

                view.setConsoleMessage("  Ingrese el nombre de la persona");
                System.out.println(view.getConsoleMessage());
                view.setConsoleMessage(" -> ");
                System.out.print(view.getConsoleMessage());
                String namePerson = scanner.nextLine();

                view.setConsoleMessage("  Ingrese el apellido de la persona");
                System.out.println(view.getConsoleMessage());
                view.setConsoleMessage(" -> ");
                System.out.print(view.getConsoleMessage());
                String surnamePerson = scanner.nextLine();

                view.setConsoleMessage("  Ingrese la edad de la persona");
                System.out.println(view.getConsoleMessage());
                view.setConsoleMessage(" -> ");
                System.out.print(view.getConsoleMessage());
                int age = scanner.nextInt();

                PersonEntity person = new PersonEntity(idPerson, namePerson, surnamePerson, age);
                personList.add(person);
            } else if (option == 2) {
                run = false;
            }
        }

        CompanyEntity company = new CompanyEntity(idCompany, nameCompany, personList);
        companyList.add(company);
        saveInfoFile(companyList);
    }

    public void showInfoCompany() {

        ArrayList<CompanyEntity> companyEntityArrayList = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            companyEntityArrayList = mapper.readValue(new File("src/main/java/net/classes/assets/info.json"), new TypeReference<>(){});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        for (CompanyEntity company: companyEntityArrayList) {
            System.out.println(" - id: " + company.getId());
            System.out.println("   - name: " + company.getName());
            if (!company.getPersonList().isEmpty()) {
                for (PersonEntity person: company.getPersonList()) {
                    System.out.println("      - Id: " + person.getId());
                    System.out.println("          - Name: " + person.getName());
                    System.out.println("          - Surname: " + person.getSurname());
                    System.out.println("          - Age: " + person.getAge());
                }
            }
        }
    }

    public void addPersonToCompany() {
        view.setConsoleMessage("-> Ingrese el id de la empresa que quiere actualizar");
        System.out.println(view.getConsoleMessage());

        Scanner scanner = view.getScanner();
        int idCompany = scanner.nextInt();

        for (CompanyEntity company: companyList) {
            if (company.getId() == idCompany) {
                //logica de informacion persona

                PersonEntity persona = new PersonEntity();
                company.getPersonList().add(persona);
                saveInfoFile(companyList);
            }
        }
    }

    public void saveInfoFile(ArrayList<CompanyEntity> companyList) {
        try {
            System.out.println("save info");
            System.out.println(" ");
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("src/main/java/net/classes/assets/info.json"), companyList);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            companyList = mapper.readValue(new File("src/main/java/net/classes/assets/info.json"), new TypeReference<>(){});
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
