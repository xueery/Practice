package Practice0923;

/**
 * @author:wangxue
 * @date:2019/9/23 21:31
 */
public class DoubleLinkedList {
    static class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){
            this.value=value;
        }
    }
    Node first=null;
    Node last=null;
    public void pushFirst(int value){
        if(first==null){
            first=new Node(value);
            last=first;
            return;
        }
        Node newNode=new Node(value);
        newNode.next=first;
        first.prev=newNode;
        first=newNode;
    }
    public void pushLast(int value){
        if(last==null){
            last=new Node(value);
            first=last;
        }
        Node newNode=new Node(value);
        last.next=newNode;
        newNode.prev=last;
        last=newNode;
    }
    public void popFirst(){
        if(first==null){
            return;
        }
        first=first.next;
        if(first==null){
            last=null;
        }else{
            first.prev=null;
        }
    }
    public void popLast(){
        if(last==null){
            return;
        }
        last=last.prev;
        if(last==null){
            first=null;
        }else{
            last.next=null;
        }
    }
    public void disprintNext(){
        Node cur=first;
        while(cur!=null){
            if(cur.next!=null) {
                System.out.print(cur.value + "-->");
            }else{
                System.out.println(cur.value);
            }
            cur=cur.next;
        }
        System.out.println();
    }

    public void disprintPrev(){
        Node cur=last;
        while (cur!=null){
            if(cur.prev!=null) {
                System.out.print(cur.value + "-->");
            }else{
                System.out.println(cur.value);
            }
            cur=cur.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DoubleLinkedList l=new DoubleLinkedList();
        l.pushFirst(7);
        l.popFirst();
        l.popLast();
        l.disprintNext();
        l.disprintPrev();
    }
}
