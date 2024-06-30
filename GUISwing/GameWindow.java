import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame
{
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    // constructor of my window
    public GameWindow()
    {
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("8-puzzle-game");
        getContentPane().setBackground(new Color(45, 68, 82));
        setResizable(false);
    }
}