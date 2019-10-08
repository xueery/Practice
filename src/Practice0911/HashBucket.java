package Practice0911;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/11 19:56
 */
public class HashBucket {
    private static class Node{
        private int key;
        private int value;
        private Node next;
    }
    private Node[] array;
    private int size;
    HashBucket(){
        array=new Node[8];
        size=0;
    }
    public int indexFunction(int key,int capacity){
        return key % capacity;
    }
    public int get(int key){
        int index=indexFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(key==cur.key){
                return cur.value;
            }
            cur=cur.next;
        }
        return -1;
    }
    public int getOrDefault(int key,int getDefault){
        int index=indexFunction(key,array.length);
        Node cur=array[index];
        while(cur!=null){
            if(key==cur.key){
                return cur.value;
            }
            cur=cur.next;
        }
        return getDefault;
    }
    public int put(int key,int value){
        int index=indexFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(key==cur.key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
            cur=cur.next;
        }
        Node node=new Node();
        node.key=key;
        node.value=value;
        node.next=head;
        array[index]=node;
        size++;
        if(size/array.length>0.75){
            resize();
        }
        return -1;
    }

    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                int index=indexFunction(cur.key,newArray.length);
                Node node=new Node();
                node.key=cur.key;
                node.value=cur.value;
                node.next=newArray[index];
                newArray[index]=node;
                cur=cur.next;
            }
        }
        array=newArray;
    }

    public int remove(int key){
        int index=indexFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                int oldValue=cur.value;
                if(cur==head){
                    array[index]=head.next;
                }else{
                   parent.next=cur.next;
                }
                size--;
                return oldValue;
            }else{
                parent=cur;
                cur=cur.next;
            }
        }
        return -1;
    }
    public boolean containKey(int key){
        int index=indexFunction(key,array.length);
        Node head=array[index];
        Node cur=head;
        while(cur!=null){
            if(key==cur.key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    public Set<Integer> keySet(){
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
    public boolean containValue(int value){
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                if(value==cur.value){
                    return true;
                }
                cur=cur.next;
            }
        }
        return false;
    }
    public Collection<Integer> values(){
        Collection<Integer> collection=new ArrayList<>();
        for(int i=0;i<array.length;i++){
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                collection.add(cur.value);
                cur=cur.next;
            }
        }
        return collection;
    }
    public Set<Map<Integer,Integer>> entrySet(){
        Set<Map<Integer,Integer>> set=new HashSet<>();
        for(int i=0;i<array.length;i++){
            Map<Integer,Integer> map=new HashMap();
            Node head=array[i];
            Node cur=head;
            while(cur!=null){
                map.put(cur.key,cur.value);
                cur=cur.next;
            }
            set.add(map);
        }
        return set;
    }
    public static void main(String[] args) {
        HashBucket map=new HashBucket();
        Random random=new Random(20190913);
        for(int i=0;i<20;i++){
            int r=random.nextInt(100);
            map.put(r,r+100);
        }
        System.out.println(map.get(50));
        System.out.println(map.remove(1));
        System.out.println(map.containKey(50));
        System.out.println(map.containValue(101));
        System.out.println(map.getOrDefault(50,100000));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
        System.out.println("Success");
    }
}