package main.java.exercises.gridchallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridChallange {

    public static void main(String[] args) {
        List<String> grid = List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv");

        var solution = new GridChallengeSolution();
        solution.gridChallenge(grid);

    }
}

class GridChallengeSolution {

    public String gridChallenge(List<String> grid) {

        List<String> orderedList = new ArrayList<>();
        char[] temp = null;

        for(String s: grid){
            temp = s.toCharArray();
            Arrays.sort(temp);
            orderedList.add(String.valueOf(temp));
        }

        for(int col = 0; col < orderedList.get(0).length(); col++){

            int row = 0;
            while(row < orderedList.size() - 1){
                String curr = orderedList.get(row).toString();
                String next = orderedList.get(row + 1).toString();

                if(curr.charAt(col) > next.charAt(col)){
                    return "NO";
                }
                row++;
            }
        }
        return "YES";
    }
}