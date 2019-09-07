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

        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameFiled.getText();
                String occupation = occupationField.getText();

                FormEvent ev = new FormEvent(this,name,occupation);
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

}
