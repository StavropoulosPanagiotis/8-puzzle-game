import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class LaunchPage implements ActionListener
{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame launchPage = new JFrame();
    JButton startButton = new JButton();

    public LaunchPage()
    {
        //for the frame
        launchPage.setSize(WIDTH, HEIGHT);
        launchPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        launchPage.setTitle("8-puzzle-game");
        launchPage.getContentPane().setBackground(new Color(45, 68, 82));
        launchPage.setResizable(false);
        launchPage.setLayout(null);
        launchPage.setVisible(true);
        
        //for the button
        startButton.setBounds(280, 200, 100, 50);
        startButton.setText("START");
        launchPage.add(startButton);
        startButton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == startButton)
        {
            launchPage.dispose(); //close the launch window
            PlayerWindow playerWindow = new PlayerWindow(); //open the "final" window
        }
    }
    
}