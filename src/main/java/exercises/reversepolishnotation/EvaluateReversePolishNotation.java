package main.java.exercises.reversepolishnotation;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        var sol = new Solution();
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(sol.evalRPN(tokens));
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int x = 0;
        int y = 0;
        String operator = null;
        int result = 0;

        if(tokens.length == 1){
            result = Integer.parseInt(tokens[0]);
        }

        for(int i = 0; i < tokens.length; i++){
            if(Character.isDigit(tokens[i].charAt(0)) || tokens[i].length() > 1){
                stack.push(tokens[i]);
            }else{
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                operator = tokens[i];

                switch(operator){
                    case "+":
                        result = y + x;
                        break;
                    case "-":
                        result = y - x;
                        break;
                    case "*":
                        result = y * x;
                        break;
                    case "/":
                        result = y / x;
                        break;
                }

                stack.push(String.valueOf(result));
            }
        }
        return result;
    }
}
