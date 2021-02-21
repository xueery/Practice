package JianzhiOffer;


/**
 * @author:wangxue
 * @date:2021/2/21 9:00
 */
// 树的子结构

// 注：如果树B为空，返回true，此时，不管树A是否为空，都为true
public class Solution17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null)return false;
        return isSame(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }
    public boolean isSame(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)return true;
        if(root1!=null && root2==null)return true;
        if(root1==null && root2!=null)return false;
        return root1.val==root2.val && isSame(root1.left,root2.left) && isSame(root1.right,root2.right);
    }
}
