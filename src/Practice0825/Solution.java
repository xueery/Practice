package Practice0825;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //树的高度
    public int calHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=calHeight(root.left);
        int right=calHeight(root.right);
        int height=Math.max(left,right)+1;
        return height;
    }
    public boolean isBalanced(Node root){
        //先判断是否为空树，空树为平衡二叉树
        //判断左子树是否为平衡二叉树
        //判断右子树是否为平衡二叉树
        //判断左右子树的高度是否相差最高为一
        if(root==null){
            return true;
        }
        boolean left=isBalanced(root.left);
        if(!left){
            return false;
        }
        boolean right=isBalanced(root.right);
        if(!right){
            return false;
        }
        int leftHeight=calHeight(root.left);
        int rightHeight=calHeight(root.right);
        int count=leftHeight-rightHeight;
        if(count<=1 &&count>=-1) {
            return true;
        }
        return false;
    }
    //查找
    public  boolean search(Node root,Node p){
        if(root==null){
            return false;
        }
        if(root==p){
            return true;
        }
        if(search(root.left,p)){
            return true;
        }
        return search(root.right,p);
    }
    //找最近公共结点
    public Node lowestCommonAncestor(Node root,Node p,Node q){
        if(root==p && root==q){
            return root;
        }
        boolean plnLeft=search(root.left,p);
        boolean qlnLeft=search(root.left,q);
        if(plnLeft &&qlnLeft){
            lowestCommonAncestor(root.left,p,q);
        }
        if(!plnLeft && !qlnLeft){
            lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
    //层序遍历
    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.println(front.val);
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
    }
    //将一个树写成字符串类型的
    public void preorder(StringBuilder sb,Node root){
        if(root==null){
            return;
        }
        sb.append("(");
        sb.append(root.val);
        if(root.left==null &&root.right!=null) {
            sb.append("()");
        }else{
            preorder(sb,root.left);
        }
        preorder(sb,root.right);
        sb.append(")");
    }
    public String treestr(Node root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(sb, root);
        String r = sb.toString();
        return r.substring(1, r.length() - 1);
    }
    public Node build(){
        Node a=new Node('a');
        Node b=new Node('b');
        Node c=new Node('c');
        Node d=new Node('d');
        Node e=new Node('e');
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        return a;
    }
}