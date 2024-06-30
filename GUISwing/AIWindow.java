import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class AIWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame aiWindow = new JFrame();
    JButton[][] jBoard;
    int x = 3;
    int y = 3;

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

        //for the board
        aiWindow.setLayout(new GridLayout(3, 3)); //makes the board
        jBoard = new JButton[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                jBoard[i][j] = new JButton("" + i);
                aiWindow.add(jBoard[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}