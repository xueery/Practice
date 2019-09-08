package Practice0823;

import java.util.ArrayList;
import java.util.List;

public class Trees {
    public static Node buileTree1(){
        Node a=new Node('A');
        Node b=new Node('B');
        Node c=new Node('C');
        Node d=new Node('D');
        Node e=new Node('E');
        Node f=new Node('F');
        Node g=new Node('G');
        Node h=new Node('H');
        a.left=b;
        b.left=d;
        b.right=e;
        e.right=h;
        a.right=c;
        c.left=f;
        c.right=g;
        return a;
    }
    public static Node buileTree2(){
        Node h=new Node('H',null,null);
        Node f=new Node('F',null,null);
        Node g=new Node('G',null,null);
        Node c=new Node('C',f,g);
        Node e=new Node('E',null,h);
        Node d=new Node('D',null,null);
        Node b=new Node('B',d,e);
        Node a=new Node('A',b,c);
        return a;
    }
    //先序遍历
    //返回为空，方法中直接打印
    public static void preOrderTraversal1(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.value);
        preOrderTraversal1(root.left);
        preOrderTraversal1(root.right);
    }
    //返回的为一个顺序表
    public static List<Character> preOrderTraversal2(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Character> list=new ArrayList<>();
        List<Character> leftOrder=preOrderTraversal2(root.left);
        List<Character> rightOrder=preOrderTraversal2(root.right);
        list.add(root.value);
        list.addAll(leftOrder);
        list.addAll(rightOrder);
        return list;
    }
    //中序遍历
    //返回为一个空，方法内直接打印
    public static void midOrderTraversal1(Node root){
        if(root==null){
            return;
        }
        midOrderTraversal1(root.left);
        System.out.print(root.value);
        midOrderTraversal1(root.right);
    }
    //返回为一个顺序表
    public static List<Character> midOrderTravsersal2(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Character> list=new ArrayList<>();
        List<Character> leftOrder=midOrderTravsersal2(root.left);
        List<Character> rightOrder=midOrderTravsersal2(root.right);
        list.addAll(leftOrder);
        list.add(root.value);
        list.addAll(rightOrder);
        return list;
    }
    //后序遍历
    //返回为空，方法内直接打印
    public static void postOrderTraversal1(Node root){
        if(root==null){
            return;
        }
        postOrderTraversal1(root.left);
        postOrderTraversal1(root.right);
        System.out.print(root.value);
    }
    //返回一个顺序表
    public static List<Character> postOrderTraversal2(Node root){
       if(root==null){
           return new ArrayList<>();
       }
       List<Character> list=new ArrayList<>();
       List<Character> leftOrder=postOrderTraversal2(root.left);
       List<Character> rightOrder=postOrderTraversal2(root.right);
       list.addAll(leftOrder);
       list.addAll(rightOrder);
       list.add(root.value);
       return list;
    }
    public static void main(String[] args) {
        Node root=buileTree2();
        preOrderTraversal1(root);
        System.out.println();
        midOrderTraversal1(root);
        System.out.println();
        postOrderTraversal1(root);
        System.out.println();
        System.out.println(preOrderTraversal2(root));
        System.out.println(midOrderTravsersal2(root));
        System.out.println(postOrderTraversal2(root));
    }
}