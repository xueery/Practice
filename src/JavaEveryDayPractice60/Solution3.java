package JavaEveryDayPractice60;

/**
 * @author:wangxue
 * @date:2020/6/28 9:47
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

// 求二叉树的第K小结点
public class Solution3 {
    static int index=0;
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(k==0)return null;
        if(pRoot!=null){
            TreeNode node=KthNode(pRoot.left,k);
            if(node!=null) return node;
            index++;
            if(index==k) return pRoot;
            node=KthNode(pRoot.right,k);
            if(node!=null) return node;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode p1=new TreeNode(5);
        TreeNode p2=new TreeNode(3);
        TreeNode p3=new TreeNode(7);
        TreeNode p4=new TreeNode(2);
        TreeNode p5=new TreeNode(4);
        TreeNode p6=new TreeNode(6);
        TreeNode p7=new TreeNode(8);
        p1.left=p2;
        p1.right=p3;
        p2.left=p4;
        p2.right=p5;
        p3.left=p6;
        p3.right=p7;
        System.out.println(KthNode(p1,3).val);
    }
}
