import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private TextPanel textPanel;
    private JButton button;

    public MainFrame(){
        super("Hello World!");

        setLayout(new BorderLayout());

        textPanel = new TextPanel();
        button = new JButton("Click me");

        add(textPanel,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);


        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
