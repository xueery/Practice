package JavaEveryDayPractice58;

/**
 * @author:wangxue
 * @date:2020/6/15 9:50
 */
import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution3 {
    //打印二叉树，比如第一行从左向右打印，第二行从右向左打印
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        if(pRoot==null) return new ArrayList<>();
        ArrayList<Integer> l=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int index=1;
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int size=queue.size();
            l=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                l.add(node.val);
            }
            if(index%2==0){
                ArrayList<Integer> indexL=new ArrayList<>();
                for(int i=l.size()-1;i>=0;i--){
                    indexL.add(l.get(i));
                }
                list.add(indexL);
            }else{
                list.add(l);
            }
            index++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s="12,2,3";
        System.out.println(s.length());
    }
}
