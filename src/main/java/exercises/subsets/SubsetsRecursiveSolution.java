package exercises.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsRecursiveSolution {

    List<List<Integer>> output = new ArrayList();
    int n, k;

    public static void main(String[] args) {
        var sol = new SubsetsRecursiveSolution();
        int[] nums = {1, 2, 3};
        var response = sol.subsets(nums);
        System.out.println(response.toString());
    }


    /**
     * Loop over the length of combination,
     * rather than the candidate numbers, and generate
     * all combinations for a given length with the help of backtracking technique.
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        backtrack(0, new ArrayList<Integer>(), nums);

        return output;
    }

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        output.add(new ArrayList(curr));

        for (int i = first; i < n; i++) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }
}
