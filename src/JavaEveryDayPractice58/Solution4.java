package JavaEveryDayPractice58;

/**
 * @author:wangxue
 * @date:2020/6/15 21:26
 */
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
//将一个二叉树序列化与反序列化
public class Solution4 {
    private int index=-1;
    String Serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        int len=str.length();
        if(index>=len/2){
            return null;
        }
        String[] strs=str.split(",");
        TreeNode node=null;
        if(!strs[index].equals("#")){
            node=new TreeNode(Integer.valueOf(strs[index]));
            node.left=Deserialize(str);
            node.right=Deserialize(str);
        }
        return node;
    }
}