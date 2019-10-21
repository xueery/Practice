package Practice0923;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/25 7:48
 */
public class TraversalTree {
    static class Node{
        int value;
        Node left=null;
        Node right=null;
        Node(int value){
            this.value=value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
    public void preTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        preTraversal(root.left);
        preTraversal(root.right);
    }
    public List<Node> orderTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Node> l = new ArrayList<>();
        List<Node> leftTree = orderTraversal(root.left);
        List<Node> rightTree = orderTraversal(root.right);
        l.addAll(leftTree);
        l.add(root);
        l.addAll(rightTree);
        return l;
    }
    public void postTraversal(Node root){
        if(root==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.println(node.value);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }
    public Node buildTree(){
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        Node e=new Node(5);
        Node f=new Node(6);
        a.left=b;a.right=c;
        b.left=d;b.right=e;
        d.left=f;
        return a;
    }
}
