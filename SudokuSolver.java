import java.util.Scanner;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[9][9];
        Scanner scanner = new Scanner(System.in);

        // Taking input from the user for the Sudoku board
        System.out.println("Enter the Sudoku board (use 0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        // Solving the Sudoku puzzle
        if (solveSudoku(board)) {
            System.out.println("Sudoku Solved:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }

        scanner.close();
    }

    public static boolean solveSudoku(int[][] board) {
        int[] emptySpot = findEmptySpot(board);
        if (emptySpot == null) {
            return true; // No empty spots, board is solved
        }

        int row = emptySpot[0];
        int col = emptySpot[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)) {
                board[row][col] = num;

                if (solveSudoku(board)) {
                    return true;
                }

                board[row][col] = 0; // Backtrack
            }
        }

        return false; // No valid number found for this spot
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        // Check if the same number exists in the row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check if the same number exists in the column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check if the same number exists in the 3x3 subgrid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int[] findEmptySpot(int[][] board) {
        int[] emptySpot = new int[2];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    emptySpot[0] = i;
                    emptySpot[1] = j;
                    return emptySpot;
                }
            }
        }
        return null; // No empty spot found
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
