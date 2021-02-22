package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/22 12:33
 */
// 二叉树的镜像
public class Solution18 {
    public void Mirror(TreeNode root){
        if(root==null)return;
        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        Mirror(root.left);
        Mirror(root.right);
    }
}
