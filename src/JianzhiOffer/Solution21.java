package JianzhiOffer;

import java.util.Stack;

/**
 * @author:wangxue
 * @date:2021/2/23 13:43
 */
// 栈的压入、弹出序列

// 新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.

public class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 || popA.length==0 || pushA.length!=popA.length)return false;
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
