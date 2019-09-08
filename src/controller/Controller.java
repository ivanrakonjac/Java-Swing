package controller;

import gui.FormEvent;
import model.*;

import java.util.List;

public class Controller {

    DataBase db = new DataBase();

    public void addPerson(FormEvent e){
        String name = e.getName();
        String occupation = e.getOccupation();
        int ageCatId = e.getAgeCat();
        String employeeCategory = e.getEmpCat();
        String taxId = e.getTaxId();
        boolean usCitizen = e.isUsCitizen();
        String gender = e.getGender();

        AgeCategory ageCategory = AgeCategory.child;

        switch (ageCatId){
            case 0:
                ageCategory=AgeCategory.child;
                break;
            case 1:
                ageCategory = AgeCategory.adult;
                break;
            case 2:
                ageCategory = AgeCategory.senior;
                break;
        }

        EmployementCategory employementCategory=EmployementCategory.other;

        if(employeeCategory=="employed") employementCategory = EmployementCategory.employed;
        else if(employeeCategory=="self-employed") employementCategory = EmployementCategory.selfEmployed;
        else if(employeeCategory=="unemployed")employementCategory = EmployementCategory.unEmployed;

        Gender pol =Gender.female;

        if(gender == "female") pol=Gender.female;
        else pol = Gender.male;

        Person person = new Person(name,occupation,ageCategory,employementCategory,taxId,usCitizen,pol);

        db.addPerson(person);
    }

    public List<Person> getPeople(){
        return  db.getPeople();
    }
}
