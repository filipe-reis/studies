package exercises.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /**
     * At each step one takes new integer into consideration and generates
     * new subsets from the existing ones.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                var temp = new ArrayList<>(curr){{add(num);}};
                newSubsets.add(temp);
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}
