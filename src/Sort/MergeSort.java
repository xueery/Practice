package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/6 11:54
 */
// 归并排序
public class MergeSort {

    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length);
    }

    public static void mergeSortInternal(int[] array,int low,int high){
        if(low+1>=high)return;

        int mid=(low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }

    public static void merge(int[] array,int low,int mid,int high){
        int[] extra=new int[high-low];
        int iExtra=0;
        int left=low;
        int right=mid;
        while (left<mid && right<high){
            if(array[left]<=array[right]){
                extra[iExtra++]=array[left++];
            }else {
                extra[iExtra++]=array[right++];
            }
        }
        while (left<mid){
            extra[iExtra++]=array[left++];
        }
        while (right<high){
            extra[iExtra++]=array[right++];
        }
        for(int i=0;i<extra.length;i++){
            array[low+i]=extra[i];
        }
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
