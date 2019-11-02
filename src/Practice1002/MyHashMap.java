package Practice1002;

import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/2 11:29
 */
public class MyHashMap {
    class Node{
        int key;
        int value;
        Node next=null;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Node[] array;
    private int size;
    MyHashMap(){
        array=new Node[10];
        size=0;
    }
    public int put(int key,int value){
        int index=searchIndex(key);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
            cur=cur.next;
        }
        Node first=new Node(key,value);
        first.next=head;
        array[index]=first;
        size++;
        if(size/array.length>0.75){
            resize();
        }
        return -1;
    }
    public int get(int key){
        int index=searchIndex(key);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }
            cur=cur.next;
        }
        return -1;
    }

    public int getOrDefault(int key,int getOrDefault){
        int index=searchIndex(key);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                return cur.key;
            }
            cur=cur.next;
        }
        return getOrDefault;
    }

    public int remove(int key){
        int index=searchIndex(key);
        Node head=array[index];
        Node cur=head;
        Node parent=null;
        while(cur!=null){
            if(cur.key==key){
                if(cur==head){
                    array[index]=head.next;
                }else{
                    parent.next=cur.next;
                }
                size--;
                return cur.value;
            }
            parent=cur;
            cur=cur.next;
        }
        return -1;
    }
    public boolean containKey(int key){
        int index=searchIndex(key);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(cur.key==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    public boolean containValue(int value){
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                if(cur.value==value){
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }
    public Set keySet(){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                set.add(cur.key);
                cur=cur.next;
            }
        }
        return set;
    }

    public Collection values(){
        Collection<Integer> c=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                c.add(cur.value);
                cur=cur.next;
            }
        }
        return c;
    }
    public Set<Map<Integer,Integer>> entrySet(){
        Set<Map<Integer,Integer>> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            Map<Integer,Integer> map=new HashMap<>();
            while(cur!=null){
                map.put(cur.key,cur.value);
                cur=cur.next;
            }
            set.add(map);
        }
        return set;
    }
    public int getSize(){
        return size;
    }
    private void resize() {
        Node[] newArrray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                int index=cur.key%(newArrray.length);
                Node first=new Node(cur.key,cur.value);
                first.next=newArrray[index];
                newArrray[index]=first;
                cur=cur.next;
            }
        }
        array=newArrray;
    }
    private int searchIndex(int key) {
        return key%array.length;
    }

    public static void main(String[] args) {
        MyHashMap map=new MyHashMap();
        Random random=new Random(20191004);
        for(int i=0;i<20;i++){
            int r=random.nextInt(50);
            map.put(r,r+50);
        }
        System.out.println(map.get(22));
        System.out.println(map.remove(12));
        System.out.println(map.getSize());
        System.out.println(map.getOrDefault(11,0));
        System.out.println(map.containKey(0));
        System.out.println(map.containValue(72));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
    }
}
