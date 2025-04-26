package net.classes;

import net.classes.controller.CompanyController;
import net.classes.model.CompanyEntity;
import net.classes.view.CompanyView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CompanyView companyView = new CompanyView();
        CompanyEntity company = new CompanyEntity();
        ArrayList<CompanyEntity> listCompany = new ArrayList<>();

        CompanyController controller = new CompanyController(companyView, company, listCompany);
        controller.showView();
    }
}