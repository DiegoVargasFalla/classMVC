package net.classes;

import net.classes.controller.CompanyController;
import net.classes.model.CompanyEntity;
import net.classes.view.CompanyView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //company view
        CompanyView companyView = new CompanyView();

        //company object
        CompanyEntity company = new CompanyEntity();

        ArrayList<CompanyEntity> listCompany = new ArrayList<>();

        //company controller
        CompanyController controller = new CompanyController(companyView, company, listCompany);

        //show view
        controller.init();
    }
}