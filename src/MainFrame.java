import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {

    private JTextArea textArea;
    private JButton button;

    public MainFrame(){
        super("Hello World!");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        button = new JButton("Click me");

        add(textArea,BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setBackground(Color.MAGENTA);
            }
        });

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {
                if(keyEvent.getKeyChar()=='b'){
                    textArea.setBackground(Color.BLACK);
                }
                else if(keyEvent.getKeyChar()=='o'){
                    textArea.setBackground(Color.ORANGE);
                }
            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });

        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                button.setText("mouse Clicked");
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                button.setText("mouse pressed");
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                button.setText("mouse released");
            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                button.setText("mouse entered");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                button.setText("mouse exited");
            }
        });

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
