package gui;

import model.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {

    private String[] colNames = {"ID","Name","Occupation","Age Category","Employement Category","US Citizen","Tax ID","Gender"};
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    private List<Person> db;

    public void setData(List<Person> db){
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Person person = db.get(row);

        switch (col){
            case 0:
                return person.getId();
            case 1:
                return person.getName();
            case 2:
                return person.getOccupation();
            case 3:
                return person.getAgeCategory();
            case 4:
                return person.getEmployementCategory();
            case 5:
                return person.isUsCitizen();
            case 6:
                return person.getTaxId();
            case 7:
                return person.getGender();
        }

        return null;
    }
}
