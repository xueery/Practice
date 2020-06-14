package JavaEveryDayPractice58;

/**
 * @author:wangxue
 * @date:2020/6/11 9:03
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
public class Solution2 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }

        return isSameTree(pRoot.left,pRoot.right);
    }
    boolean isSameTree(TreeNode pRoot,TreeNode qRoot){
        if(pRoot==null && qRoot==null){
            return true;
        }
        if(pRoot==null || qRoot==null){
            return false;
        }
        if(pRoot.val!=qRoot.val){
            return false;
        }
        return isSameTree(pRoot.left,qRoot.right)&& isSameTree(pRoot.right,qRoot.left);
    }
}
