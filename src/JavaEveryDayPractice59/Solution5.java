package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/18 9:47
 */
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
//二叉搜索树转换为双向链表
public class Solution5 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null && pRootOfTree.right==null){

        }
        TreeNode left=Convert(pRootOfTree.left);
        TreeNode p=left;
        while(p!=null && p.right!=null){
            p=p.right;
        }
        if(left!=null){
            p.right=pRootOfTree;
            pRootOfTree.left=p;
        }
        TreeNode right=Convert(pRootOfTree.right);
        if(right!=null){
            right.left=pRootOfTree;
            pRootOfTree.right=right;
        }
        return left!=null?left:pRootOfTree;
    }
}
