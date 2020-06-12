package JavaEveryDayPractice58;

/**
 * @author:wangxue
 * @date:2020/6/11 8:48
 */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Solution {
    // 根据中序遍历，找到pNode结点的下一个结点
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        //如果它有右节点，那就到它的右节点，一直找他右节点的左孩子，直到没有左孩子
        if(pNode.right!=null){
            TreeLinkNode cur=pNode.right;
            TreeLinkNode p=null;
            while(cur!=null){
                p=cur;
                cur=cur.left;
            }
            return p;
        }
        // 如果它没有右孩子并且不是根节点，找他的父节点并且它的父节点的左孩子是他
        // 如果它的父节点的右孩子是他，那必须向上继续找
        while(pNode.next!=null){
            TreeLinkNode proot=pNode.next;
            if(proot.left==pNode){
                return proot;
            }
            pNode=pNode.next;
        }
        return null;
    }
}
