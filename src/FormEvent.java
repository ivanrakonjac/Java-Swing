import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCat;
    private String empCat;
    private String taxId;
    private boolean usCitizen;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,String name,String occupation,int ageCat,String empCat,String taxId,boolean usCitizen) {
        super(source);

        this.name=name;
        this.occupation=occupation;
        this.ageCat=ageCat;
        this.empCat=empCat;
        this.taxId=taxId;
        this.usCitizen = usCitizen;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAgeCat(){return ageCat;}

    public String getEmpCat(){return empCat;}

    public String getTaxId() {
        return taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setAgeCat(int ageCat) {
        this.ageCat = ageCat;
    }

    public void setEmpCat(String empCat) {
        this.empCat = empCat;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
