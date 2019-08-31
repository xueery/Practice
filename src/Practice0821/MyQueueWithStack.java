package Practice0821;

import java.util.Stack;
//用栈实现队列（先进先出）
public class MyQueueWithStack {
    //利用两个栈
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();
    public void push(int x){
        stack1.push(x);
    }
    //先将元素加入栈1中，删除栈2中的元素，当栈2中没有元素时，将栈1中的元素全部挪如栈2中，再进行删除
    public int pop(){
        if(stack2.empty()) {
            while (!stack1.empty()) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.pop();
    }
    //获取栈2中的栈顶元素，即为先进入栈1中的元素，即先进入队列的元素
    public int peek(){
        if(stack2.empty()) {
            while (!stack1.empty()) {
                int x = stack1.pop();
                stack2.push(x);
            }
        }
        return stack2.peek();
    }
    public boolean empty(){
        return stack1.empty()&&stack2.empty();
    }
}
