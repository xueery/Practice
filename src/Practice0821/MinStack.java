package Practice0821;

import java.util.Stack;

public class MinStack {
    Stack<Integer> normal=new Stack<>();
    Stack<Integer> min=new Stack<>();
    //将元素插入栈中
    public void push(int x){
       normal.push(x);
       if(min.empty()){
           min.push(x);
       }else{
           int m=min.peek();
           if(x<=m){
               min.push(x);
           }else{
               min.push(m);
           }
       }
    }
    //删除栈顶元素
    public void pop(){
        normal.pop();
        min.pop();
    }
    //获得normal栈中的栈顶元素
    public int top(){
        return normal.peek();
    }
    //获得normal栈中的最小元素
    public int getMin(){
        return min.peek();
    }
}