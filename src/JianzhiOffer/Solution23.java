package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/27 10:16
 */
// 二叉搜索树的后序遍历序列
// 思路：对于每一棵树，后序遍历的话，根结点对应数组的最后一个

//找到每个子树的分界点，对于每个树来说都是  左子树的所有结点 < 根结点 < 右子树的所有结点
public class Solution23 {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0){
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }

    public boolean isBST(int[] sequence,int start,int end){
        if(start>=end){
            return true;
        }
        int spilt=start;
        int val=sequence[end];
        for(;spilt<end && sequence[spilt]<val;spilt++);
        for(int i=spilt;i<end;i++){
            if(sequence[i]<val){
                return false;
            }
        }
        return isBST(sequence,start,spilt-1) &&
                isBST(sequence,spilt,end-1);
    }
}
