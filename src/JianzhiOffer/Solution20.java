package JianzhiOffer;

import java.util.Stack;

/**
 * @author:wangxue
 * @date:2021/2/23 13:41
 */
// 包含 min 函数的栈
public class Solution20 {

    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();

    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            if(minStack.peek()>node){
                minStack.push(node);
            }
        }
    }

    public void pop() {
        int num=stack.pop();
        if(!minStack.isEmpty() && minStack.peek()==num){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
