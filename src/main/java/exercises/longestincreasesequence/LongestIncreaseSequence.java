package main.java.exercises.longestincreasesequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestIncreaseSequence {

    public static void main(String[] args) {
        int[] arr = {0,1,0,3,2,3};

        LISSolution sol = new LISSolution();

        sol.lengthOfLIS(arr);
    }

}

class LISSolution{
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        int prevIndex = -1;
        for(int i = 0; i < nums.length; i++){
            int actualIndex = map.get(nums[i]);

            if(prevIndex == -1){
                res++;
                prevIndex = actualIndex;
            }else if(actualIndex > prevIndex){
                if(nums[actualIndex] != nums[prevIndex]){
                    res++;
                    prevIndex = actualIndex;
                }
            }
        }
        return res;
    }
}