package main.java.exercises.trappingrainwater;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Resposta no neetcode!
 * Essas implementações não funcionaram
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        var sol = new Solution();
        var res = sol.trap2(height);
        System.out.println(res);
     }
}

class Solution{

    public int trap2(int[] height) {
        // Math.min(i, j) * distance
        int size = height.length;
        int base = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = 1;
        int result  = 0;
        int temp = 0;
        while(j < size - 1){
            int distance = j - i - 1;
            if(height[i] > height[j]){
                if(distance == 0){
                    stack.push(height[i]);
                }

                if(height[j] > stack.peek()){
                    sum = 0;
                    int last = 0;
                    base = 0;
                    while(height[j] >= stack.peek()){
                        last = stack.pop();
                        sum = sum + last;
                        base++;
                    }
                 //calculate trap
                    temp = 0;
                    temp = Math.min(last, height[j]) * base - sum;
                    sum = sum + height[j];
                    j++;
                }else{
                    stack.push(height[j]);
                    j++;
                }

            }else{
                //calculate trap
                result = result + Math.min(height[i], height[j]) * distance - sum + temp;
                i = j;
                j++;
                //clear stack
            }
        }
        return result;
    }

    public int trap(int[] height) {
        // Math.min(i, j) * distance
        int size = height.length;
        int distance = 0;
        int result = 0;
        int sum = 0;
        Map<Integer, Boolean> visited = new HashMap<>();

        for(int i = 0; i < size - 2; i++){
            int j = i+1;

            while(j <= size - 1){
                if(!visited.containsKey(j)){
                    if(height[i] > height[j]){
                        if(j == (size - 1)){
                            visited.put(i, true);
                        }else{
                            sum = sum + height[j];
                            visited.put(j, true);
                        }

                    }else{
                        break;
                    }
                }
                j++;
            }

            if(!visited.containsKey(i)){
                distance = j - i - 1;
                result = result + Math.min(height[i], height[j]) * distance - sum;
            }

            sum = 0;
        }
        return result;
    }

}
