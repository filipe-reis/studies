package main.java.exercises.rottingoranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        /**
         * 2 1 1
         * 1 1 0
         * 0 1 1
         */

        int[] arr = new int[3];
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
//        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        var sol = new RottingOrangesSolution();
//
//        System.out.println(sol.orangesRotting(grid));

    }
}


class RottingOrangesSolution {
    int res = 0;
    int m = 0;
    int n = 0;


    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int rowInit = 0;
        int colInit = 0;
        int count1s = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    rowInit = i;
                    colInit = j;
                }else if (grid[i][j] == 1){
                    count1s++;
                }
            }
        }

        //no fresh oranges
        if(count1s == 0){
            return 0;
        }

        rottingOranges(rowInit, colInit, grid);

        int count1sAgain = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j]);
                if (grid[i][j] == 1){
                    count1sAgain++;
                }
            }
            System.out.println("");
        }

        if(count1sAgain > 0){
            return -1;
        }
        return res;
    }

    public void rottingOranges(int i, int j, int[][] grid){

        Queue<Pair> queue = new ArrayDeque<>();
        boolean hasToRotting;

        if(grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 3;

        hasToRotting = findNext(i, j, grid);


        if(hasToRotting){
            res++;
        }

        if(!queue.isEmpty()){
            Pair exec = queue.remove();
            rottingOranges(exec.key, exec.value, grid);
        }
    }

    private boolean findNext(int i, int j, int[][] grid) {
        boolean hasToRotting = false;
        int down = i +1;
        if(down < m){
            if(grid[down][j] == 1) {
                Pair pair = new Pair(down, j);
//                queue.add(pair);
                grid[down][j] = 3;
                hasToRotting = true;
            }
        }

        int up = i -1;
        if(up > 0){
            if(grid[up][j] == 1) {
                Pair pair = new Pair(up, j);
//                queue.add(pair);
                grid[up][j] = 3;
                hasToRotting = true;
            }
        }

        int right = j +1;
        if(right < n){
            if(grid[i][right] == 1) {
                Pair pair = new Pair(i,right);
//                queue.add(pair);
                grid[i][right] = 3;
                hasToRotting = true;
            }
        }

        int left = j -1;
        if(left > 0){
            if(grid[i][left] == 1) {
                Pair pair = new Pair(i,left);
//                queue.add(pair);
                grid[i][left] = 3;
                hasToRotting = true;
            }
        }
        return hasToRotting;
    }
}
