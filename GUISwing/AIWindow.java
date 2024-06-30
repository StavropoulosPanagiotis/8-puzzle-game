import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class AIWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame aiWindow = new JFrame();

    public AIWindow()
    {
        //for the frame
        aiWindow.setSize(WIDTH, HEIGHT);
        aiWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aiWindow.setTitle("8-puzzle-game");
        aiWindow.getContentPane().setBackground(new Color(45, 68, 82));
        aiWindow.setResizable(false);
        aiWindow.setLayout(null);
        aiWindow.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}