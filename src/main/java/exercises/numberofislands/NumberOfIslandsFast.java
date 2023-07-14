package main.java.exercises.numberofislands;

/**
 * Essa solução não usa nenhuma estrutura de dados auxiliar
 * porém, altera a estrutura de dados inicial do problema.
 * <p>
 * Em tempo de execução ela performa melhor que uma solução que usa um set
 */
public class NumberOfIslandsFast {

    int countIsland = 0;
    int m = 0;
    int n = 0;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    countIsland++;
                    verifyIsland(i, j, grid);
                }
            }
        }
        return countIsland;
    }

    public void verifyIsland(int i, int j, char[][] grid) {

        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // essa linha altera a estrutura original

        if (i + 1 < m) {
            verifyIsland(i + 1, j, grid);
        }

        if (j + 1 < n) {
            verifyIsland(i, j + 1, grid);
        }
        if (j - 1 >= 0) {
            verifyIsland(i, j - 1, grid);
        }

        if (i - 1 >= 0) {
            verifyIsland(i - 1, j, grid);
        }

    }


}
