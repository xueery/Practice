package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/17 10:38
 */

import java.util.ArrayList;

 class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }

public class Solution3 {
     // 在一个二叉树中，寻找一条路径上的和等于target的路径
    public ArrayList<ArrayList<Integer>> listAll=new ArrayList<>();
    public ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root==null) return listAll;
        list.add(root.val);
        target-=root.val;
        if(target==0 && root.left==null && root.right==null){
            // 不直接添加list，是因为list是一个引用，最后会进行更改，所以不能添加引用
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        // 要进行回退，回退到父节点继续找
        list.remove(list.size()-1);
        return listAll;
    }
}
