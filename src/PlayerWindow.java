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
                jBoard[i][j].addActionListener(this);
                board[i][j] = new Cell(i, j, -1, true);
                playerWindow.add(jBoard[i][j]);
            }
        }

        createInitialState();
        System.out.println(isFinalState());
       
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
        List<String> list = new ArrayList<String>(Arrays.asList(valueOptions)); //used to eliminate an option later in the for loop

        emptyRow = JOptionPane.showOptionDialog(null, "Choose in which row the empty cell should be: ", "EMPTY CELL ROW", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyRowOptions, 0) + 1;
        emptyCollumn = JOptionPane.showOptionDialog(null, "Choose in which collumn the empty cell should be: ", "EMPTY CELL COLLUMN", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, emptyCollumnOptions, 0) + 1;
        createEmptySpace(emptyRow, emptyCollumn);
        
        //create initial state
        for(int i = 1; i < x; i++)
        {
            for(int j = 1; j < y; j++)
            {
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
            }
        }
    }
    
    //creates the empty space of the puzzle
    public void createEmptySpace(int emptyRow, int emptyCollumn)
    {
        jBoard[emptyRow][emptyCollumn].setVisible(false); //makes button invisible (we have our empty space now)
        board[emptyRow][emptyCollumn].setValue(0);
        board[emptyRow][emptyCollumn].setIsEmpty(true);
    }

    //It takes the cell that we want to move and returns an array of ints where array[0] is the row of the available move and array[1] is the collumn
    public int[] validMove(int row, int collumn)
    {
        int[] validArray = {-1, -1};
        int[] emptyArray = {-1, -1};
        
        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                if(board[i][j].getIsEmpty()){
                    emptyArray[0] = i;
                    emptyArray[1] = j;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};

        // Check all possible moves
        for (int i = 0; i < 8; i++) {
            int newRow = row + dx[i];
            int newCol = collumn + dy[i];

            if (newRow == emptyArray[0] && newCol == emptyArray[1] && isValid(newRow, newCol)) {
                validArray[0] = newRow;
                validArray[1] = newCol;
                break;
            }
        }
        return validArray;
    }

    // Function to check if a given cell is within the board boundaries
    public boolean isValid(int x, int y) {
        return (x >= 1 && x <= 3 && y >= 1 && y <= 3);
    }

    //cheks if board is in final state
    public boolean isFinalState() {
        int[][] finalState = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 0} // Assuming 0 represents the empty cell
        };
    
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + 1][j + 1].getIsEmpty()) {
                    if (finalState[i][j] != 0) {
                        return false; // Empty cell position must match
                    }
                } else {
                    if (board[i + 1][j + 1].getValue() != finalState[i][j]) {
                        return false; // Non-empty cell value must match
                    }
                }
            }
        }
        return true;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int rowOfButtonPressed = 0;
        int collumnOfButtonPressed = 0;

        //find the row and the collumn of the pressed button
        for(int i = 1; i < x; i ++){
            for(int j = 1; j < y; j++){
                if(jBoard[i][j] == e.getSource()){
                    rowOfButtonPressed = i;
                    collumnOfButtonPressed = j;
                }
            }
        }
    }

}