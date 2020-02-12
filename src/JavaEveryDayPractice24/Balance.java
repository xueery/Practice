package JavaEveryDayPractice24;

/**
 * @author:wangxue
 * @date:2019/11/30 21:26
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class Balance {
    public static boolean isBalance(TreeNode root) {
        // write code here
        if(root==null){
            return true;
        }
        //判断左子树是不是平衡二叉树
        if(!isBalance(root.left)){
            return false;
        }
        //判断右子树是不是平衡二叉树
        if(!isBalance(root.right)){
            return false;
        }
        //计算左右子树的高度
        int leftLength=heightTree(root.left);
        int rightLength=heightTree(root.right);
        if(Math.abs(leftLength-rightLength)>1){
            return false;
        }
        return true;
    }
    private static int heightTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftCount=heightTree(root.left);
        int rightCount=heightTree(root.right);
        int height=Math.max(leftCount,rightCount)+1;
        return height;
    }
    private static TreeNode buildTree(){
        TreeNode root=new TreeNode(2);
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(6);
        TreeNode n5=new TreeNode(7);
        root.left=n1;
        root.right=n2;
        n1.left=n3;
        n3.left=n4;
        n2.right=n5;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=buildTree();
        System.out.println(isBalance(root));
    }
}
