import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class DecisionWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    //initialization of frame and button
    JFrame decisionWindow = new JFrame();
    JButton aiButton = new JButton();
    JButton playerButton = new JButton();

    // constructor of my window
    public DecisionWindow()
    {
        //for the frame
        decisionWindow.setSize(WIDTH, HEIGHT);
        decisionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        decisionWindow.setTitle("8-puzzle-game");
        decisionWindow.getContentPane().setBackground(new Color(45, 68, 82));
        decisionWindow.setResizable(false);
        decisionWindow.setLayout(null);
        decisionWindow.setVisible(true);

        //2 buttons needed (Play with or without AI)
        aiButton.setBounds(190, 150, 300, 50);
        aiButton.setText("PLAY WITH AI");
        decisionWindow.add(aiButton);

        playerButton.setBounds(190, 200, 300, 50);
        playerButton.setText("PLAY ALONE");
        decisionWindow.add(playerButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}