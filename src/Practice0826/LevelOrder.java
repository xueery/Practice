package Practice0826;

import java.util.*;

public class LevelOrder {
    static class Element{
        Node node;
        int level;
        Element(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static List<List<Character>> LevelOrderTraversal(Node root){
        List<List<Character>> retList=new ArrayList<>();
        if(root==null){
            return retList;
        }
        Queue<Element> queue=new LinkedList<>();
        queue.add(new Element(root,0));
        while(!queue.isEmpty()){
            Element front=queue.poll();
            if(front.level==retList.size()){
                retList.add(new ArrayList<>());
            }
            retList.get(front.level).add(front.node.val);
            if(front.node.left!=null){
                queue.add(new Element(front.node.left,front.level+1));
            }
            if(front.node.right!=null){
                queue.add(new Element(front.node.right,front.level+1));
            }
        }
        return retList;
    }
    //判断是否为完全二叉树
    //1）层序遍历树，直到遇到null
    //2）检查队列中是否还有not null
    public static boolean isComplete(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(true){
            Node front=queue.poll();
            if(front==null){
                break;
            }
            queue.add(front.left);
            queue.add(front.right);
        }
        while(!queue.isEmpty()){
            if(queue.poll()!=null){
                return false;
            }
        }
        return true;
    }
    //非递归写树的前序遍历
    public static void preOrderNotR(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                System.out.print(cur.val);
                stack.add(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
    }
    //非递归写树的中序遍历
    public static void inorderNotR(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
            System.out.print(top.val);
        }
    }
    //非递归的后序遍历
    public static void postOrderNotR(Node root){
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        Node last=null;
        while(!stack.isEmpty() || cur!=null){
            while(cur!=null){
                stack.add(cur);
                cur=cur.left;
            }
            Node top=stack.peek();
            if(top.right==null || top.right==last){
                stack.pop();
                System.out.print(top.val);
                last=top;
            }else{
                cur=top.right;
            }
        }
    }
    public static Node build(){
        Node a=new Node('a');
        Node b=new Node('b');
        Node c=new Node('c');
        Node e=new Node('d');
        a.left=b;
        a.right=c;
        b.right=e;
        return a;
    }
    public static void main(String[] args) {
        Node root=build();
        System.out.print(LevelOrderTraversal(root));
        System.out.println(isComplete(root));
        preOrderNotR(root);
        System.out.println();
        inorderNotR(root);
        System.out.println();
        postOrderNotR(root);
    }
}