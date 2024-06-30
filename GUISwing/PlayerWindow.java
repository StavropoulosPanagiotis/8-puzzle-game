import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;

public class PlayerWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame playerWindow;
    JButton[][] jBoard;
    int x = 3;
    int y = 3;

    public PlayerWindow()
    {
        //for the frame
        playerWindow = new JFrame();
        playerWindow.setSize(WIDTH, HEIGHT);
        playerWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playerWindow.setTitle("8-puzzle-game");
        playerWindow.getContentPane().setBackground(new Color(45, 68, 82));
        playerWindow.setResizable(false);
        playerWindow.setLayout(null);
        playerWindow.setVisible(true);

        //for the board(grid)
        playerWindow.setLayout(new GridLayout(3, 3)); //makes the board
        jBoard = new JButton[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                jBoard[i][j] = new JButton("" + i);
                playerWindow.add(jBoard[i][j]);
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}