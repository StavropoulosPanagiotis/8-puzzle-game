import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.GridLayout;

public class PlayerWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame playerWindow;
    JButton[][] jBoard;
    int x = 4;
    int y = 4;

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
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                jBoard[i][j] = new JButton("");
                playerWindow.add(jBoard[i][j]);
            }
        }

        createInitialState();
    }

    
    
    //ask user for initial state
    public void createInitialState()
    {
        //for the empty cell
        String[] emptyRowOptions = {"1", "2", "3"};
        String[] emptyCollumnOptions = {"1", "2", "3"};
        
        int emptyRow;
        int emptyCollumn;
        
        emptyRow = JOptionPane.showOptionDialog(null, "Choose in which row the empty cell should be: ", "EMPTY CELL ROW", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyRowOptions, 0) + 1;
        emptyCollumn = JOptionPane.showOptionDialog(null, "Choose in which collumn the empty cell should be: ", "EMPTY CELL COLLUMN", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyCollumnOptions, 0) + 1;
        createEmptySpace(emptyRow, emptyCollumn);
        
        
    }
    
    //creates the empty space of the puzzle
    public void createEmptySpace(int emptyRow, int emptyCollumn)
    {
        jBoard[emptyRow][emptyCollumn].setVisible(false); //makes button invisible (we have our empty space now)
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}