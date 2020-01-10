package JavaEveryDayPractice05;

import java.util.Stack;

/**
 * @author:wangxue
 * @date:2019/11/9 23:17
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()) {
                int n = stack1.pop();
                stack2.push(n);
            }
        }
        int p=stack2.pop();
        return p;
    }
}
