import javax.swing.*;

public class GameOfLife {
    public static void main(String[] args) {
        //Initializing number of columns and rows
        int rows = 10, cols = 10;
        //Initializing the grid at the initial state
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        //Printing the original state of the game
        System.out.println("Original Generation.");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    System.out.print("+");
                } else {
                    System.out.println("#");
                }
            }
            System.out.println();
        }
        System.out.println();
        nextGen(grid, cols, rows);
    }

    //Method for printing the next generation
    public static void nextGen(int grid[][], int rows, int cols) {
        int[][] futureGen = new int[cols][rows];

        for (int i = 0; i < cols - 1; i++) {
            for (int j = 0; j < rows; j++) {
                //Find number of alive neighbours
                int aliveNb = 0;
                for (int k = -1; k < 1; k++) {
                    for (int l = -1; l < 1; l++) {
                        aliveNb += grid[i + k][j + l];
                    }
                    //The cell needs to be subtracted from its neighbours as it was counted before
                    aliveNb -= grid[i][j];

                    //Implementation of the rules of the game
                    //Cell is lonely and dies
                    if ((grid[i][j] == 1) && (aliveNb < 2))
                        futureGen[i][j] = 0;
                        // Cell dies due to over population
                    else if ((grid[i][j] == 1) && (aliveNb > 3))
                        futureGen[i][j] = 0;

                        // A new cell is born
                    else if ((grid[i][j] == 1) && (aliveNb == 3))
                        futureGen[i][j] = 1;

                        // Remains the same
                    else
                        futureGen[j][j] = grid[i][j];
                }
            }
        }
        System.out.println("Next Generation");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (futureGen[i][j] == 0)
                    //System.out.print("+");
                    JOptionPane.showMessageDialog(null,"+");
                else
                    //System.out.print("#");
                    JOptionPane.showMessageDialog(null,"#");
            }
            System.out.println();
        }
    }
}
