package main.java.exercises.minstack;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {
        var sol = new Solution();

        sol.push(-2);
        sol.push(0);
        sol.push(-3);
        sol.getMin(); // return -3
        sol.pop();
        sol.top();    // return 0
        sol.getMin(); // return -2
    }
}

class Solution {

    int[] stack;
    int position;
    Stack<Integer> minStack;

    public Solution() {
        stack = new int[30000];
        position = 0;
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack[position] = val;
        position = position + 1;

        if(!minStack.isEmpty()){
            if(val <= minStack.peek()){
                minStack.push(val);
            }
        }else{
            minStack.push(val);
        }
    }

    public void pop() {
        int top = stack[position - 1];
        if(!minStack.isEmpty() && top == minStack.peek()){
            minStack.pop();
        }
        stack[position - 1] = 0;
        position = position - 1;

    }

    public int top() {
        return stack[position - 1];
    }

    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
