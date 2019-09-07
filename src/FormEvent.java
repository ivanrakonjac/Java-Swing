import java.util.EventObject;

public class FormEvent extends EventObject {

    private String name;
    private String occupation;
    private int ageCat;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,String name,String occupation,int ageCat) {
        super(source);

        this.name=name;
        this.occupation=occupation;
        this.ageCat=ageCat;
    }

    public String getName() {
        return name;
    }

    public String getOccupation() {
        return occupation;
    }

    public int getAgeCat(){return ageCat;}

    public void setName(String name) {
        this.name = name;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
