package main.java.exercises.minimumcost;

import java.util.Arrays;

public class MinimumCost {

    public static void main(String[] args) {
        MinimumCostSolution sol = new MinimumCostSolution();
        int[] arr = {4,9,13,15,6};
        sol.solve(arr);
    }
}

class MinimumCostSolution {
    public int solve(int[] A) {
        int cost = 0;
        Arrays.sort(A);
        int[] costs = new int[A.length];
        for(int i = 0; i < A.length - 1; i++){
            costs[i] = A[i] + A[i+1];
            A[i+1] = costs[i];
        }
        for(int c:costs){
            cost += c;
        }
        return cost;
    }
}

