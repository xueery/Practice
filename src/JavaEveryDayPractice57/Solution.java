package JavaEveryDayPractice57;

//二叉搜索树的后序遍历
public class Solution {
    // 判断一个数组是否为一个二叉搜索树的后序遍历结果
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0){
            return false;
        }
        return verifyInternal(sequence,0,sequence.length-1);
    }
    public boolean verifyInternal(int[] sequence,int left,int right){
        if(left>right) return true;
        int root=right;
        // key 为根节点
        int key=sequence[right];
        int i;
        // 找出左右子树的分割点
        for(i=0;i<right;i++){
           if(sequence[i]>key)
               break;
        }
        // 判断如果右子树中有小于根节点，直接返回false
        for(int j=i;j<right;j++){
            if(sequence[j]<key){
                return false;
            }
        }
        // 再递归式的进行遍历
        return verifyInternal(sequence,0,i-1) && verifyInternal(sequence,i,root-1);
    }
}