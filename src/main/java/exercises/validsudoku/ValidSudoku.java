package main.java.exercises.validsudoku;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        isValidSudoku(board);
    }

    private static boolean isValidSudoku(char[][] board) {

        Map[] test = new HashMap[4];
        Map<Character, Integer> rows[] = new HashMap[9];
        Map<Character, Integer> cols[] = new HashMap[9];
        Map<Character, Integer> squares[] = new HashMap[9];
        test[1] = new HashMap<>();
        test[2] = new HashMap<>();
        test[1].put(1, 3);
        test[2].put('2', "test");

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            cols[i] = new HashMap<>();
            squares[i] = new HashMap<>();
        }

        // Iterate over the board and check each cell.
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                // Check if the cell value is already present in the row, column, or subsquare.
                if (rows[i].containsKey(c) ||
                        cols[j].containsKey(c) ||
                        squares[(i / 3) * 3 + j / 3].containsKey(c)
                ) {
                    return false;
                }

                // Add the cell value to the appropriate hash table.
                rows[i].put(c, 1);
                cols[j].put(c, 1);
                squares[(i / 3) * 3 + j / 3].put(c, 1);
            }
        }

        // All cells are valid.
        return true;
    }
}
