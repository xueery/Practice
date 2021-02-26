package JianzhiOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author:wangxue
 * @date:2021/2/23 13:44
 */
// 从上往下打印二叉树
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
        }
        return list;
    }
}

