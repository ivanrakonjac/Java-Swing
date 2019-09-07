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

    public FormPanel(){
        Dimension dim = getPreferredSize();
        System.out.println(dim);
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occupationlabel = new JLabel("Occupation: ");
        nameFiled = new JTextField(10);
        occupationField = new JTextField(10);

        okBtn = new JButton("OK");

        //Kako proslediti text unet u FormPanelu, nakon pritiska dugmeta, u MainFrame => odgovor na kraju fajla
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameFiled.getText();
                String occupation = occupationField.getText();

                FormEvent ev = new FormEvent(this,name,occupation);

                if(formListener!=null){
                    formListener.formEventOccured(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder(" Add person ") ;
        Border outefBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outefBorder,innerBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        //FIRST row ---------------------

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,5);

        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;

        gc.anchor = GridBagConstraints.LINE_START;
        add(nameFiled,gc);

        //SECOND row ----------------------

        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 0;
        gc.gridy = 1;

        gc.insets = new Insets(0,0,0,5);

        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationlabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;

        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField,gc);

        //THIRD row -----------------------

        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx=1;
        gc.gridy=2;

        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    };

    public void setFormListener(FormListener listener){
        this.formListener=listener;
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

