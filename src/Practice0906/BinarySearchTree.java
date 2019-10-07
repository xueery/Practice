package Practice0906;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/6 21:22
 */
public class BinarySearchTree {
    public class Node{
        int key;
        int value;
        Node left=null;
        Node right=null;
        Node(int key){
            this.key=key;
        }
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node root=null;
    public int get(int key){
        Node node=root;
        while(node!=null){
            if(node.key==key){
                return node.value;
            }else if(key<node.key){
                node=node.left;
            }else{
                node=node.right;
            }
        }
        return -1;
    }
    public int put(int key,int value){
        if(root==null){
            root=new Node(key);
            root.value=value;
            return -1;
        }
        Node node=root;
        Node parent=null;
        while(node!=null){
            if(node.key==key){
                int oldValue=node.value;
                node.value=value;
                return oldValue;
            }else if(key<node.key){
                parent=node;
                node=node.left;
            }else{
                parent=node;
                node=node.right;
            }
        }
        Node newNode= new Node(key);
        newNode.value=value;
        if(key<parent.key){
            parent.left=newNode;
        }else{
            parent.right=newNode;
        }
        return -1;
    }
    public int getOrDefault(int key,int defaultValue){
        Node cur=root;
        while(cur!=null){
            if (cur.key==key){
                return cur.value;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return defaultValue;
    }
    public Set<Integer> keySet(){
        Set<Integer> set=new HashSet<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            set.add(node.key);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return set;
    }
    public Set<Integer> keySet1(){
        Set<Integer> set=new HashSet<>();
        inorderSet(set,root);
        return set;
    }

    private void inorderSet(Set<Integer> set, Node root) {
        if(root!=null){
            inorderSet(set,root.left);
            set.add(root.key);
            inorderSet(set,root.right);
        }
    }

    public Collection<Integer> values(){
        Collection<Integer> collection=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            collection.add(node.value);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return collection;
    }
    public boolean containkey(int key){
        Node cur=root;
        while(cur!=null){
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
        if(root==null) {
            return false;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            if(node.value==value){
                return true;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return false;
    }
    public int remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(cur.key==key){
                int oldValue=cur.value;
                delete(parent,cur);
                return oldValue;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return -1;
    }

    private void delete(Node parent, Node cur) {
        if(cur.left==null){
            if(parent==null){
                root=cur.right;
            }else if(cur==parent.left) {
                parent.left = cur.right;
            }else{
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(parent==null){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{
          Node goat=cur.left;
          Node goatParent=cur;
          while(goat.right!=null){
              goatParent=goat;
              goat=goat.right;
          }
          cur.key=goat.key;
          cur.value=goat.value;
          //此处分为cur的左子树上有没有右子
            // 如果没有
          if(goatParent.left==goat){
              goatParent.left=goat.left;
          }else{
              //如果有
              goatParent.right=goat.left;
          }
        }
    }
    //返回所有的键值对
    public static class Entry{
        private int key;
        private int value;
        public int getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    //利用层序遍历返回所有键值对
    public Set<Entry> entrySet(){
        Set<Entry> set=new HashSet<>();
        if(root==null){
            return set;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            Entry entry=new Entry();
            entry.key=cur.key;
            entry.value=cur.value;
            set.add(entry);
            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        return set;
    }
    //利用中序遍历返回所有键值对
    public Set<Entry> entrySet1(){
        Set<Entry> set=new HashSet<>();
        inorderTraversal(set,root);
        return set;
    }

    private void inorderTraversal(Set<Entry> set, Node root) {
        if(root!=null){
            inorderTraversal(set,root.left);
            Entry entry=new Entry();
            entry.key=root.key;
            entry.value=root.value;
            set.add(entry);
            inorderTraversal(set,root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree();
        tree.put(6,5);
        tree.put(1,1);
        tree.put(4,7);
        tree.put(3,4);

        int retGet=tree.get(3);
        System.out.println(retGet);
        System.out.println(tree.getOrDefault(9,-1));
        System.out.println(tree.keySet1());
        System.out.println("=====================");
        System.out.println(tree.values());
        System.out.println(tree.containkey(7));
        System.out.println(tree.containValue(7));
        System.out.println(tree.remove(1));
        Set<Entry> set=tree.entrySet1();
        for(Entry e:set){
            System.out.println(e.key);
            System.out.println(e.value);
        }
    }
}