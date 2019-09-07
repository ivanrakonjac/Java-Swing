import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationlabel;
    private JTextField nameFiled;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;

    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    public FormPanel(){
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationlabel = new JLabel("Occupation: ");
        nameFiled = new JTextField(10);
        occupationField = new JTextField(10);
        ageList = new JList();
        empCombo = new JComboBox();
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax ID:");

        maleRadio = new JRadioButton("male");
        femaleRadio = new JRadioButton("female");
        genderGroup = new ButtonGroup();

        //Set up gender radios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);

        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");

        //Set up tax ID
        taxLabel.setEnabled(false);
        taxField.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                taxLabel.setEnabled(citizenCheck.isSelected());
                taxField.setEnabled(citizenCheck.isSelected());
            }
        });

        //Set up list box
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18 to 65"));
        ageModel.addElement(new AgeCategory(2,"over 65"));
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110,66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        //Set up combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("employed");
        empModel.addElement("self-employed");
        empModel.addElement("unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);

        okBtn = new JButton("OK");

        //Kako proslediti text unet u FormPanelu, nakon pritiska dugmeta, u MainFrame => odgovor na kraju fajla
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameFiled.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();
                String taxId = taxField.getText();
                boolean usCitizen = citizenCheck.isSelected();

                String genderCommand = genderGroup.getSelection().getActionCommand();

                System.out.println(empCat);

                FormEvent ev = new FormEvent(this,name,occupation,ageCat.getId(),empCat,taxId,usCitizen,genderCommand);

                if(formListener!=null){
                    formListener.formEventOccured(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder(" Add person ") ;
        Border outefBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outefBorder,innerBorder));

       layoutComponents();

    };

    public void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //FIRST row ---------------------
        gc.gridy = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,5);

        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.anchor = GridBagConstraints.LINE_START;
        add(nameFiled,gc);

        //SECOND row ----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;

        gc.insets = new Insets(0,0,0,5);

        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationlabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;

        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField,gc);

        //Third row-------------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Age: "), gc);

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);

        //Fourth row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Employement: "), gc);

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(empCombo, gc);

        //Fifth row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("US citizen: "), gc);

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(citizenCheck, gc);

        //Sixth row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(taxLabel, gc);

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(taxField, gc);

        //Seventh row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Gender: "), gc);

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(maleRadio, gc);

        //Eighth row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx=1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(femaleRadio, gc);

        //Last row -----------------------
        gc.gridy++;

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx=1;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);
    }

    public void setFormListener(FormListener listener){
        this.formListener=listener;
    }

}

class AgeCategory{
    private String text;
    private int id;

    public AgeCategory(int id, String text){
        this.id=id;
        this.text=text;
    }

    public String toString(){
        return text;
    }

    public int getId(){
        return id;
    }
}



/*
Odgovor na pitanje: Kako proslediti text unet u FormPanelu, nakon pritiska dugmeta, u MainFrame => odgovor na kraju fajla?

To se elegantno moze uraditi kreiranjem FrameEvent klase koja extenduje Event Java klasu, gde se na pritisak dugmeta kreira novi objekat klase FormEvent.
Dodacemo joj jos parametre koji nama trebaju a to su ime i zanimanje.
Kao i svaki dogadjaj, da bi imao smisla, treba postojati neki listener za njega.
Taj listener cemo dodati u MainFrame-u.
Da bi smo ga dodali moramo ga prvo napraviti, pa kreiramo interfejs FormListener koji extenduje EventListener java klasu.
Interfejs ima samo jednu funkciju public void formEventOccured(FormEvent e), pomocu koje se moze definisati sta treba da se odradi kada dodje do FormEventa.
Mogucnost kreiranja listenera za FormEvent pruzamo kroz funkciju klase FormPanel -> setListenr(FormListener listener).

Tako da iz MainFrame-a pozivamo sledeci kod:

formPanel.setFormListener(new FormListener() {
    public void formEventOccured(FormEvent e) {
        String name = e.getName();
        String occupation = e.getOccupation();

        textPanel.appendText(name + " :" + occupation + "\n");
    }
});

-setujemo novi FormListener
-u formEventOccured definisemo sta treba da se desi

i tako elegantno dobijamo interakciju 2 klase

 */

