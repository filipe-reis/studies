package exercises.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Stack<Integer> permutation = new Stack<>();

        backtrack(result, nums, used, permutation);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, boolean[] used, Stack<Integer> permutation){
        if(permutation.size() == nums.length){
            result.add(permutation.stream().toList());
        }
        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                used[i] = true;
                permutation.push(nums[i]);
                backtrack(result, nums, used, permutation);
                used[i] = false;
                permutation.pop();
            }
        }
    }
}
