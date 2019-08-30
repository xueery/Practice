package Practice0821;

import java.util.*;
//用队列实现栈（先进后出）
public class MyStackWithQueue {
    private Queue<Integer> queue=new LinkedList<>();
    public void push(int x){
        queue.add(x);
    }
    //先把队列中的前size-1个元素删除，再加之队尾，可删除队列中的最后一个元素
    public int pop(){
        int size=queue.size();
        for(int i=0;i<size-1;i++) {
            int v=queue.poll();
            queue.add(v);
        }
        return queue.poll();
    }
    //先把队列中的前size-1个元素删除，再加之队尾，可得到队列中的最后一个元素
    // 得到之后再加入队列中，恢复原来的队列顺序
    public int top(){
        int size=queue.size();
        for(int i=0;i<size-1;i++) {
            int v=queue.poll();
            queue.add(v);
        }
        int v=queue.poll();
        queue.add(v);
        return v;
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
