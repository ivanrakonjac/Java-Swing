package gui;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private JButton button;
    private FormPanel formPanel;
    private JFileChooser fileChooser;
    private TablePanel tablePanel;

    private Controller controller; //MainFrame zove kontroler kada zeli da doda nesto u bazu

    public MainFrame(){
        super("Hello World!");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        button = new JButton("Click me");
        formPanel = new FormPanel();
        fileChooser = new JFileChooser();
        tablePanel = new TablePanel();

        controller = new Controller();

        tablePanel.setData(controller.getPeople());

        //Dodavanje menija
        setJMenuBar(createMenuBar());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textPanel.appendText("Hello\n");
            }
        });

        //dodajem listener koji slusa gui.FormEvent
        formPanel.setFormListener(new FormListener() {
            public void formEventOccured(FormEvent e) {
                controller.addPerson(e);
                tablePanel.refresh();
            }
        });

        add(formPanel,BorderLayout.WEST);
        add(tablePanel,BorderLayout.CENTER);
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
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.add(save);
        fileMenu.add(exit);

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

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int action = JOptionPane.showConfirmDialog(MainFrame.this,"Do you really want to exit the application?","Confirm exit",JOptionPane.OK_CANCEL_OPTION);
                if(action == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        importData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        return menuBar;
    }
}
