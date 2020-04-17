package Holiday02;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/1/19 12:39
 */
public class Main {
    //27.移除元素
    public static int removeElement(int[] nums, int val) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[length++] = nums[i];
            }
        }
        return length;
    }
    public static int searchInsert(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
        int[] num={1,3,5,6};
        System.out.println(searchInsert(num,5));
    }
}
