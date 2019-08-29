package Practice0821;

import java.util.LinkedList;

public class MyQueue {
    private static class Node{
       int val;
       Node next=null;
       Node(int val){
           this.val=val;
       }
    }
    public Node front=null;
    public Node last=null;
    public int size=0;
    //尾插
    public void add(int element){
        if(front==null){
            front=last=new Node(element);
        }
        else{
            last.next=new Node(element);
            last=last.next;
        }
        size++;
    }
    //头删
    public int pop(){
        if(front==null){
            return -1;
        }
        int val=front.val;
        front=front.next;
        if(front==null){
            last=null;
        }
        size--;
        return val;
    }
    public int front(){
        return front.val;
    }
    public int last(){
        return last.val;
    }
    public int size(){
        return size;
    }
    public boolean empty(){
        return size==0;
    }
}
