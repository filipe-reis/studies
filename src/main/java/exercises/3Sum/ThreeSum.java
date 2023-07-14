package main.java.exercises;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        var solution = new ThreeSumSolution();
        System.out.println(solution.threeSumFinalSolution(nums));

    }
}

class ThreeSumSolution {

    public List<List<Integer>> threeSumFinalSolution(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }

        output.addAll(result);

        return output;
    }

    public List<List<Integer>> threeSumTest(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        boolean hasZero = false;

        for(Integer num : nums){
            if(num == 0){
                hasZero = true;
                break;
            }
        }

        while(left < right){
            sum = nums[left] + nums[right];

            if(sum < 0){
                if(sum + nums[right - 1] == 0 && right - 1 > left){
                    current = new ArrayList<>(List.of(nums[left], nums[right - 1], nums[right]));
                    Collections.sort(current);

                    result.add(current);
                    left++;
                }else if(sum + nums[right - 1] < 0){
                    left++;
                }else{
                    right--;
                }
            }else if(sum > 0){
                if(sum - nums[left + 1] == 0 && left + 1 < right){
                    current = new ArrayList<>(List.of(nums[left], nums[left + 1], nums[right]));
                    Collections.sort(current);

                    result.add(current);
                    right--;
                }else if(sum - nums[left + 1] < 0){
                    right--;
                }else{
                    left++;
                }
            }else{

                current = new ArrayList<>(List.of(nums[left], nums[right], 0));
                Collections.sort(current);

                result.add(current);
                left++;
                right--;
            }
        }

        return result.stream().toList();
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> entry = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();
        int first = 0;
        int second = 1;
        int complement = 0;
        List<Integer> current = new ArrayList<>();

        for(Integer num : nums){
            if(entry.containsKey(num)){
                entry.put(num, entry.get(num) + 1);
            }else{
                entry.put(num, 1);
            }

        }

        while(second < nums.length){

            complement = (nums[first] + nums[second]) * (-1);
            if(complement == nums[first] || complement == nums[second]){
                if(entry.get(complement) == 1){
                    break;
                }
            }
            if(complement == nums[first] && complement == nums[second]){
                if(entry.get(complement) == 2){
                    break;
                }
            }

            if(entry.containsKey(complement)){

                current = new ArrayList<>(List.of(nums[first], nums[second], complement));
                Collections.sort(current);

                result.add(current);

            }

            second++;
            first++;
        }

        return result.stream().toList();
    }
}