import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class GameWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    //initialization of frame and button
    JFrame gameWindow = new JFrame();
    JButton aiButton = new JButton();
    JButton playerButton = new JButton();

    // constructor of my window
    public GameWindow()
    {
        //for the frame
        gameWindow.setSize(WIDTH, HEIGHT);
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setTitle("8-puzzle-game");
        gameWindow.getContentPane().setBackground(new Color(45, 68, 82));
        gameWindow.setResizable(false);
        gameWindow.setLayout(null);
        gameWindow.setVisible(true);

        //2 buttons needed (Play with or without AI)
        aiButton.setBounds(190, 150, 300, 50);
        aiButton.setText("PLAY WITH AI");
        gameWindow.add(aiButton);

        playerButton.setBounds(190, 200, 300, 50);
        playerButton.setText("PLAY ALONE");
        gameWindow.add(playerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}