package Practice0825;

import java.util.Arrays;
import java.util.List;

public class buildTreeWithArray {
    //数组给出前序和中序遍历构建树
    public static Node buildTrees(char[] preorder,char[] inorder){
        if(preorder.length==0){
            return null;
        }
        char rootVal=preorder[0];
        int leftCount=0;
        for(int i=0;i<inorder.length;i++){
            if(rootVal==inorder[i]){
                leftCount=i;
            }
        }
        char[] leftpreorder= Arrays.copyOfRange(preorder,1,leftCount+1);
        char[] leftinorder=Arrays.copyOfRange(inorder,0,leftCount);
        Node left=buildTrees(leftpreorder,leftinorder);
        char[] rightpreorder=Arrays.copyOfRange(preorder,leftCount+1,preorder.length);
        char[] rightinorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        Node right=buildTrees(rightpreorder,rightinorder);
        Node root=new Node(rootVal);
        root.left=left;
        root.right=right;
        return root;
    }
    //用数组中序和后序构建树
    public static Node buildTrees2(char[] inorder,char[] postorder){
        if(postorder.length==0){
         return null;
        }
        char rootVal=postorder[postorder.length-1];
        Node root=new Node(rootVal);
        int leftCount=0;
        for(int i=0;i<inorder.length;i++) {
            if (rootVal == inorder[i]) {
                leftCount = i;
            }
        }
        char[] leftinorder= Arrays.copyOfRange(inorder,0,leftCount);
        char[] leftpostorder=Arrays.copyOfRange(postorder,0,leftCount);
        Node left=buildTrees2(leftinorder,leftpostorder);
        char[] rightinorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        char[] rightpostorder=Arrays.copyOfRange(postorder,leftCount,postorder.length-1);
        Node right=buildTrees2(rightinorder,rightpostorder);
        root.left=left;
        root.right=right;
        return root;
    }
    public static class ReturnVal{
        Node root;
        int used;
    }
    public static ReturnVal buildTreePreorder(List<Character> preorder){
        if(preorder.size()==0){
            ReturnVal rv=new ReturnVal();
            rv.root=null;
            rv.used=0;
            return rv;
        }
        int rootValue=preorder.get(0);
        if(rootValue=='#'){
            ReturnVal rv=new ReturnVal();
            rv.root=null;
            rv.used=1;
            return rv;
        }
        ReturnVal leftRV=buildTreePreorder(preorder.subList(1,preorder.size()));
        ReturnVal rightRv=buildTreePreorder(preorder.subList(1+leftRV.used,preorder.size()));
        Node root=new Node(rootValue);
        root.left=leftRV.root;
        root.right=rightRv.root;
        ReturnVal rv=new ReturnVal();
        rv.root=root;
        rv.used=1+leftRV.used+rightRv.used;
        return rv;
    }
    public static void main(String[] args) {
        char[] preorder={'A','B','D','E','C'};
        char[] inorder={'D','B','E','A','C'};
        char[] postorder={'D','E','B','C','A'};
        List<Character> preorder1=Arrays.asList('A','B','#','#','#');
        Node root=buildTrees(preorder,inorder);
        Node root1=buildTrees2(inorder,postorder);
        ReturnVal root2=buildTreePreorder(preorder1);
        System.out.println("successful");
    }
}
