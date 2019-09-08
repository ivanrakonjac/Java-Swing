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

        //Dodavanje menija
        setJMenuBar(createMenuBar());

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
                String taxId = e.getTaxId();
                boolean usCitizen = e.isUsCitizen();
                String gender = e.getGender();

                if(usCitizen==false) taxId="non defined";

                textPanel.appendText(name + " : " + occupation + " " +ageCat + " " + empolyeeCategory +" "+ taxId+" " + usCitizen + " " + gender + "\n");
            }
        });

        add(formPanel,BorderLayout.WEST);
        add(textPanel,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);


        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JMenuBar createMenuBar(){
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");

        JMenuItem exportData = new JMenuItem("Export data");
        JMenuItem importData = new JMenuItem("Import data");
        JMenuItem save = new JMenuItem("Save");

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.add(save);

        JMenu showMenu = new JMenu("Show");
        JMenuItem showItem = new JMenuItem("Show item");
        showMenu.add(showItem);
        windowMenu.add(showMenu);

        JMenu helpMenu = new JMenu("Help");
        JCheckBoxMenuItem helpItem = new JCheckBoxMenuItem("Call for help");
        helpMenu.add(helpItem);
        windowMenu.add(helpMenu);

        //Dodavanje listenera
        exportData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Export data");
            }
        });

        importData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Import data");
            }
        });


        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
}
