package JianzhiOffer;

import java.util.ArrayList;

/**
 * @author:wangxue
 * @date:2021/2/27 10:19
 */
// 二叉树中和为某一值的路径
public class Solution24 {
    public ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null)return result;
        list.add(root.val);
        target-=root.val;
        if(target==0 && root.left==null && root.right==null){
            result.add(new ArrayList<Integer>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return result;
    }
}
