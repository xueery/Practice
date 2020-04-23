package Holiday07;

/**
 * @author:wangxue
 * @date:2020/1/26 21:10
 */
public class Main {
    public int[] sortArrayByParity(int[] A){
        int i=0;
        int j=A.length-1;
        while(i<j){
            if(i<j && A[i]%2==0){
                i++;
            }
            if(i<j && A[j]%2==1){
                j--;
            }
            swap(A,i,j);
        }
        return A;
    }
    private void swap(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }

    public int pivotIndex(int[] nums){
        int leftSum = 0;
        int rightSum = 0;
        for(int i=0;i<nums.length;i++){
            rightSum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            rightSum-=nums[i];
            if(leftSum==rightSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}