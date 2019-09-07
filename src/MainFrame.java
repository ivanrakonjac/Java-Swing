import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private JButton button;
    private FormPanel formPanel;

    public MainFrame(){
        super("Hello World!");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        button = new JButton("Click me");
        formPanel = new FormPanel();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textPanel.appendText("Hello\n");
            }
        });

        //dodajem listener koji slusa FormEvent
        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCat();
                String empolyeeCategory = e.getEmpCat();

                textPanel.appendText(name + " : " + occupation + " " +ageCat + " " + empolyeeCategory + "\n");
            }
        });

        add(formPanel,BorderLayout.WEST);
        add(textPanel,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);


        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
