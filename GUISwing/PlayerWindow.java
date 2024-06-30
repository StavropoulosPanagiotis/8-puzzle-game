import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class PlayerWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame playerWindow = new JFrame();

    public PlayerWindow()
    {
        //for the frame
        playerWindow.setSize(WIDTH, HEIGHT);
        playerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow.setTitle("8-puzzle-game");
        playerWindow.getContentPane().setBackground(new Color(45, 68, 82));
        playerWindow.setResizable(false);
        playerWindow.setLayout(null);
        playerWindow.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}