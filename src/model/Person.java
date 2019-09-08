package model;

public class Person {

    private static int count = 0;

    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmployementCategory employementCategory;
    private String taxId;
    private boolean usCitizen;
    private Gender gender;


    public Person(String name, String occupation, AgeCategory ageCategory, EmployementCategory employementCategory, String taxId, boolean usCitizen, Gender gender) {
        this.id = count++;
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employementCategory = employementCategory;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public EmployementCategory getEmployementCategory() {
        return employementCategory;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public Gender getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public void setEmployementCategory(EmployementCategory employementCategory) {
        this.employementCategory = employementCategory;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
