package main.java.exercises.numberofislands;

import java.util.*;

public class NumberOfIslands {
    /**
     * [["1","0","1","1","1"],["1","0","1","0","1"],["1","1","1","0","1"]]
     * 1 0 1 1 1
     * 1 0 1 0 1
     * 1 1 1 0 1
     * @param args
     */
    public static void main(String[] args) {
//        char[][] grid = {{'1','0','1','1','1'}, {'1', '0','1','0','1'},{'1','1','1','0','1'}};
        char[][] grid = {{'1','1','1'}, {'0', '1','0'},{'1','1','1'}};
        var sol = new NumberOfIslandsSolution();

        System.out.println(sol.numIslands(grid));

        /**
         * Proximos passos:
         * Criar uma matriz auxiliar para gravar se uma posição ja foi visitada ou não
         * a matriz será uma matriz de boolean e substituirá o set para limpar o código
         *
         * Manter a recursividade
         * Manter as regras da recursividade
         */
    }
}

class NumberOfIslandsSolution {
    int countIsland = 0;
    int i = 0;
    int j = 0;
    int m = 0;
    int n = 0;
    Set<int[][]> set = new HashSet<>();

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visit[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                        countIsland++;
                        verifyIsland(i, j, grid, visit);
                }
            }
        }
        return countIsland;
    }

    public void verifyIsland(int i, int j, char[][] grid, boolean[][] visit) {

        if (grid[i][j] == '0' || visit[i][j]) {
            return;
        }

        visit[i][j] = true;
        if (i + 1 < m) {
            verifyIsland(i + 1, j, grid, visit);
        }

        if (j + 1 < n) {
            verifyIsland(i, j + 1, grid, visit);
        }
        if (j - 1 >= 0) {
            verifyIsland(i, j - 1, grid, visit);
        }

        if (i - 1 >= 0) {
            verifyIsland(i - 1, j, grid, visit);
        }
    }
}