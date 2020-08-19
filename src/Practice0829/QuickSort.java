package Practice0829;

import java.util.Arrays;
import java.util.Stack;

import static Practice0828.SelectSort.swap;

/**
 * @author:wangxue
 * @date:2019/8/29 10:24
 */
public class QuickSort {

    
    public static void quickSort(int[] array){
        int left=0;
        int right=array.length-1;
        quickSortInternal(array,left,right);
    }
    //快速排序的递归写法
    private static void quickSortInternal(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        //1.确定基准值:array[right]作为基准值
        //2.遍历，小的左，大的右
        //int[] pivotIndex=partition3(array,left,right);
        int pivotIndex=partition2(array,left,right);
        //分出两个区间
        //[left,pivotIndex-1]
        //[pivotIndex+1,right]
        //3.治
        quickSortInternal(array,left,pivotIndex-1);
        quickSortInternal(array,pivotIndex+1,right);
    }
    //快排的非递归写法（用栈实现）
    public static void quickSortNoR(int[] array){
        Stack<Integer> stack=new Stack<>();
        stack.push(array.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left=stack.pop();
            int right=stack.pop();
            if(left>=right){
                continue;
            }
            int pivotIndex=partition(array,left,right);
            stack.push(right);
            stack.push(pivotIndex+1);
            stack.push(pivotIndex-1);
            stack.push(left);
        }
    }
    private static int partition(int[] array, int left, int right) {
        int pivot=array[right];
        int small=left;
        int big=right;
        while(small<big){
            while(small<big && array[small]<=pivot){
                small++;
            }
            array[big]=array[small];
            while(small<big && array[big]>=pivot){
                big--;
            }
            array[small]=array[big];
        }
        array[small]=pivot;
        return small;
    }
    private static int partition1(int[] array,int left,int right){
        int less=left;//蓝色的箭头
        int i=left;//红色的箭头
        int pivot=array[right];
        for(;i<right;i++){
            if(array[i]<pivot){
                swap(array,i,less);
                less++;
            }
        }
        swap(array,right,less);
        return less;
    }
    private static int partition2(int[] array, int left, int right) {
        int pivot=array[right];
        int small=left;
        int big=right;
        while(small<big){
            while(small<big && array[small]<=pivot){
                small++;
            }
            while(small<big && array[big]>=pivot){
                big--;
            }
            swap(array,small,big);
        }
        swap(array,small,right);
        return small;
    }
    public static int[] partition3(int[] array,int left,int right){
        int pivot=array[right];
        int i=left;
        int less=left;
        int great=right;
        while(i<great){
            if(array[i]==pivot){
                i++;
            }else if(array[i]<pivot){
                swap(array,i,less);
                i++;
                less++;
            }else{
                if(i<great && array[great]>pivot){
                    great--;
                }
                swap(array,i,great);
            }
        }
        return new int[]{less,great-1};
    }
    public static void main(String[] args) {
        int[] array={1,7,8,0,5,6,7,4};
        quickSortNoR(array);
        System.out.println(Arrays.toString(array));
    }
}
