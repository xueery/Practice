package Practice1002;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/4 13:21
 */
public class MyTreeMap {
    class Node{
        int key;
        int value;
        Node left;
        Node right;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node root=null;
    public int put(int key,int value){
        if(root==null){
            root=new Node(key,value);
            return -1;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.key==key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node newNode=new Node(key,value);
        if(key<parent.key){
            parent.left=newNode;
        }else {
            parent.right = newNode;
        }
        return -1;
    }
    public int get(int key){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return -1;
    }
    public int getOrDefult(int key,int getOrDefault){
        Node cur=root;
        while(cur!=null){
            if(cur.key==key){
                return cur.value;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return getOrDefault;
    }
    public Set keySet(){
        Set<Integer> set=new HashSet<>();
        inorder(set,root);
        return set;
    }

    private void inorder(Set<Integer> set, Node root) {
        if(root==null){
            return;
        }
        inorder(set,root.left);
        set.add(root.key);
        inorder(set,root.right);
    }

    public Collection values(){
        if(root==null){
            return null;
        }
        Collection<Integer> collection=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            collection.add(cur.value);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        return collection;
    }
    public boolean containKey(int key){
        Node cur=root;
        while (cur!=null){
            if(cur.key==key){
                return true;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return false;
    }
    public boolean containValue(int value){
        if(root==null){
            return false;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if(cur.value==value){
                return true;
            }
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyTreeMap map=new MyTreeMap();
        map.put(1,5);
        map.put(3,4);
        map.put(2,1);
        map.put(2,88);
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.get(8));
        System.out.println(map.getOrDefult(8,100));
        System.out.println(map.containKey(1));
        System.out.println(map.containValue(9));
    }
}
