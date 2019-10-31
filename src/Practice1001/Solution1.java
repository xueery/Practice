package Practice1001;

import java.util.Stack;

/**
 * @author:wangxue
 * @date:2019/10/1 10:44
 */
public class Solution1 {
    //用栈实现队列
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int ret=0;
        if(!stack2.isEmpty()){
            ret=stack2.pop();
            return ret;
        }else{
            while(!stack1.isEmpty()){
                int e=stack1.pop();
                stack2.push(e);
            }
            ret=stack2.pop();
        }
        return ret;
    }
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            int a=n%2;
            int i=a^0;
            if(i==1){
              count++;
            }
            n=n/2;
        }
        return count;
    }
    public static void main(String[] args) {
        Solution1 s=new Solution1();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.NumberOf1(11));
    }
}