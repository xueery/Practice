package Practice0823;

import java.util.*;

public class TreeWithOutClass {
    private static List<Character> list;
    //先序遍历，顺序表定义在外部
    public static void preOrder(Node root){
        if(root==null){
            return;
        }
        list.add(root.value);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static List<Character> preOrderTraversal3(Node root){
        list=new ArrayList<>();
        preOrder(root);
        return list;
    }
    //中序遍历，顺序表定义在外部
    public static void midOrder(Node root){
        if(root==null){
            return;
        }
        midOrder(root.left);
        list.add(root.value);
        midOrder(root.right);
    }
    public static List<Character> midOrderTraversal3(Node root){
        list=new ArrayList<>();
        midOrder(root);
        return list;
    }
    //后序遍历
    static List<Character> list1=new ArrayList<>();
    public static List<Character> postOrderTraversal3(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        postOrderTraversal3(root.left);
        postOrderTraversal3(root.right);
        list1.add(root.value);
        return list1;
    }
    public static void main(String[] args) {
        Trees tree=new Trees();
        Node root=tree.buileTree1();
        System.out.println(preOrderTraversal3(root));
        System.out.println(midOrderTraversal3(root));
        System.out.println(postOrderTraversal3(root));
    }
}
