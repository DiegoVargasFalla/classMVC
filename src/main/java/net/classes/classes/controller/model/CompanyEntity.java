package net.classes.classes.controller.model;

import java.util.ArrayList;

public class CompanyEntity {
    private Long id;
    private String name;
    private ArrayList<PersonEntity> personList;

    public CompanyEntity(Long id, String name, ArrayList<PersonEntity> personList) {
        this.id = id;
        this.name = name;
        this.personList = personList;
    }

    public CompanyEntity() {}

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

    public ArrayList<PersonEntity> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<PersonEntity> personList) {
        this.personList = personList;
    }
}
