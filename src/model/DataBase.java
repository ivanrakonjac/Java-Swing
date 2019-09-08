package model;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private ArrayList<Person> people;

    public DataBase(){
        this.people = new ArrayList<Person>();
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public List<Person> getPeople(){
        return people;
    }
}
