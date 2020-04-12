package JavaEveryDayPractice52;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/3/31 20:37
 */
public class Main2 {

    //根据大顶堆写堆排序
    public static void heapSortMax(int[] nums){
        createMaxHeap(nums);
        for(int i=0;i<nums.length;i++){
            swap(nums,0,nums.length-i-1);
            heapifyMax(nums,nums.length-i-1,0);
        }
    }
    public static void createMaxHeap(int[] nums){
        for(int i=(nums.length-2)/2;i>=0;i--){
            heapifyMax(nums,nums.length,i);
        }
    }

    private static void heapifyMax(int[] nums, int length, int index) {
        while(true){
            int left=2*index+1;
            if(left>length-1){
                return;
            }
            int min=left;
            if(left+1<=length-1 && nums[left+1]>nums[left]){
                min=left+1;
            }
            if(nums[min]>nums[index]){
                swap(nums,min,index);
            }
            index=min;
        }
    }
    private static void swap(int[] nums, int i, int j) {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        heapSortMax(array);
        System.out.println(Arrays.toString(array));
    }
}
