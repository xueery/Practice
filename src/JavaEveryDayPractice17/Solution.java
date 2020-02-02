package JavaEveryDayPractice17;

/**
 * @author:wangxue
 * @date:2019/11/24 9:14
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return;
        }
        if(root.left!=null && root.right!=null){
            TreeNode node=root.left;
            root.left=root.right;
            root.right=node;
            Mirror(root.left);
            Mirror(root.right);
        }else if(root.left==null && root.right!=null){
            root.left=root.right;
            root.right=null;
            Mirror(root.left);
        }else{
            root.right=root.left;
            root.left=null;
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
