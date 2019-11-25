package Practice1025;

import List.List;
import Practice1002.MyHashMap;

/**
 * @author:wangxue
 * @date:2019/10/28 21:34
 */
public class MyHashSet {
    ListNode[] array;
    int size=0;
    public MyHashSet() {
        array=new ListNode[1000];
    }

    public void add(int key) {
        int index=getIndex(array,key);
        ListNode cur=array[index];
        ListNode head=cur;
        while (cur!=null){
            if(cur.val==key){
                return;
            }
        }
        ListNode newNode=new ListNode(key);
        newNode.next=head;
        array[index]=newNode;
        size++;
        if(size>0.75*array.length){
            resize();
        }
    }

    private void resize() {
        ListNode[] newArray=new ListNode[2*array.length];
        for(int i=0;i<array.length;i++){
            ListNode head=array[i];
            ListNode cur=head;
            while(cur!=null){
                int num=cur.val;
                int index=getIndex(newArray,num);
                ListNode newNode=new ListNode(num);
                newNode.next=newArray[index];
                newArray[index]=newNode;
                cur=cur.next;
            }
        }
        array=newArray;
    }

    public void remove(int key) {
        int index=getIndex(array,key);
        ListNode head=array[index];
        ListNode cur=head;
        ListNode parent=null;
        while(cur!=null){
            if(cur.val==key) {
                if (cur == head) {
                    head = head.next;
                    array[index] = head;
                } else {
                    parent.next = cur.next;
                }
                size--;
                return;
            }else{
                parent=cur;
                cur=cur.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=getIndex(array,key);
        ListNode cur=array[index];
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    private int getIndex(ListNode[] array,int key){
        return key%array.length;
    }

    public static void main(String[] args) {
        MyHashSet set=new MyHashSet();
        set.add(2);
        set.add(2);
        set.add(2);
        set.add(2);
        set.remove(2);
        System.out.println(set.contains(2));
    }
}
