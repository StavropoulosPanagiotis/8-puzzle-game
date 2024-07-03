import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.GridLayout;

public class PlayerWindow implements ActionListener
{
    //dimensions of the frame
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    JFrame playerWindow;
    JButton[][] jBoard;
    Cell[][] board;

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
        board = new Cell[x][y];
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                jBoard[i][j] = new JButton("");
                board[i][j] = new Cell(i, i, -1, true);
                playerWindow.add(jBoard[i][j]);
            }
        }

        createInitialState();
    }

    
    
    //ask user for initial state
    public void createInitialState()
    {
        //for the empty cell
        int emptyRow;
        int emptyCollumn;
        String[] emptyRowOptions = {"1", "2", "3"};
        String[] emptyCollumnOptions = {"1", "2", "3"};

        //for the other cells
        int value;
        String[] valueOptions = {"1", "2", "3", "4", "5", "6", "7", "8"};
        List<String> list = new ArrayList<String>(Arrays.asList(valueOptions)); //used to eliminate an option later in the loop

        emptyRow = JOptionPane.showOptionDialog(null, "Choose in which row the empty cell should be: ", "EMPTY CELL ROW", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyRowOptions, 0) + 1;
        emptyCollumn = JOptionPane.showOptionDialog(null, "Choose in which collumn the empty cell should be: ", "EMPTY CELL COLLUMN", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyCollumnOptions, 0) + 1;
        createEmptySpace(emptyRow, emptyCollumn);
        
        //create initial state
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                //check if cell is the "empty cell"
                if(board[i][j].getValue() == 0)
                {
                    continue;
                }
                //if not then update both the values and the options left
                int selectedIndex = JOptionPane.showOptionDialog(null, "Enter the value of the cell in the " + i + " row and the " + j + " collumn: ", "CELL VALUE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, valueOptions, valueOptions[0]);
                value = Integer.parseInt(valueOptions[selectedIndex]);

                jBoard[i][j].setText("" + value);
                board[i][j].setValue(value);
                board[i][j].setIsEmpty(false);

                list.remove(selectedIndex);
                valueOptions = list.toArray(new String[0]);

                for(int k = 0; k < list.size(); k++){
                    System.out.print(list.get(k) + " ");
                }
                System.out.println();
            }
        }
    }
    
    //creates the empty space of the puzzle
    public void createEmptySpace(int emptyRow, int emptyCollumn)
    {
        jBoard[emptyRow][emptyCollumn].setVisible(false); //makes button invisible (we have our empty space now)
        board[emptyRow][emptyCollumn].setValue(0);
        board[emptyRow][emptyCollumn].setIsEmpty(false);
    }

    //checks if move is valid(if value already exists or a specific cell is already occupied)
    public boolean isMoveValid(int row, int collumn)
    {
        boolean isValid = true;

        //check if move is out of bounds
        if(row < 1 || row > 3 || collumn < 1 || collumn > 3)
        {
            isValid = false;
        }

        //check if cell is already occupied
        if(!board[row][collumn].getIsEmpty())
        {
            isValid = false;
        }

        return isValid;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}