package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/5 16:21
 */
// 快速排序
public class QuickSort {
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
    }
    public static void quickSortInternal(int[] array,int left,int right){
        if(left>=right)return;
        int privotIndex=partition(array,left,right);
        quickSortInternal(array,left,privotIndex-1);
        quickSortInternal(array,privotIndex+1,right);
    }
    public static int partition(int[] array,int left,int right){
        int pivot=array[right];
        int small=left;
        int big=right;
        while(small<big){
            while (small<big && array[small]<=pivot){
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
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
