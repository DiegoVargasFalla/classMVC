package net.classes.controller;

import net.classes.model.CompanyEntity;
import net.classes.model.PersonEntity;
import net.classes.view.CompanyView;

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

    public void showView() {

        while (view.getRunning()) {

            view.showView();
            Scanner scanner = view.getScanner();

            try {
                int option = scanner.nextInt();

                if (option == 1) {
                    addCompany();
                    showInfoCompany();
                } else if (option == 2) {
                    return;
                } else if (option == 0) {
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

        view.setConsoleMessage("  Ingrese el id de la empresa");
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
    }
    public void showInfoCompany() {
        for (CompanyEntity company: companyList) {
            System.out.println(" - id: " + company.getId());
            System.out.println("    - name: " + company.getName());
            if (!company.getPersonList().isEmpty()) {
                for (PersonEntity person: company.getPersonList()) {
                    System.out.println("       - Id: " + person.getId());
                    System.out.println("          - Name: " + person.getName());
                    System.out.println("          - Surname: " + person.getSurname());
                    System.out.println("          - Age: " + person.getAge());
                }
            }

        }
    }

    public void addPersonToCompany() {
        //make method
    }
}
