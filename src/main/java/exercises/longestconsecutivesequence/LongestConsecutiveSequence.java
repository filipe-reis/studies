package main.java.exercises.longestconsecutivesequence;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        var sol = new LongestConsecutiveSequenceSolution();
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        var result = sol.longestConsecutive(nums);
        System.out.println(result);
    }
}

class LongestConsecutiveSequenceSolution{
    public int longestConsecutive(int[] nums){
        int result = 0;
        int currQtd = 0;
        int lastNumber = 0;
        int currNumber = 0;
        Map<Integer, Integer> uniques = new HashMap<>();
        //Set para remover duplicados
        for(Integer num : nums){
            if(!uniques.containsKey(num)){
                uniques.put(num, 1);
            }

        }

        //COLOCAR NUM HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.addAll(uniques.keySet());

        //ITERAR PELA HEAP VERIFICANDO SE O ATUAL É IGUAL O ANTERIOR
        while(!pq.isEmpty()){
            currNumber = pq.remove();

            if(currNumber == 0 && lastNumber == 0){
                currQtd++;
            }else if(currNumber - 1 == lastNumber){
                currQtd++;
            }else{
                currQtd = 1;
            }

            if(currQtd > result){
                result = currQtd;
            }

            lastNumber = currNumber;
        }

        return result;

    }

}
