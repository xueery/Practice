package Practice0830;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/30 10:11
 */
public class MergeSort {
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length);
    }
    //归并排序的递归写法
    private static void mergeSortInternal(int[] array, int low, int high) {
        if(low+1>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int length=high-low;
        int[] extra=new int[length];
        int iextra=0;
        int iLeft=low;
        int iRight=mid;
        while(iLeft<mid && iRight<high){
            if(array[iLeft]<=array[iRight]){
                extra[iextra++]=array[iLeft++];
            }else{
                extra[iextra++]=array[iRight++];
            }
        }
        while(iLeft<mid){
            extra[iextra++]=array[iLeft++];
        }
        while(iRight<high){
            extra[iextra++]=array[iRight++];
        }
        for(int i=0;i<length;i++){
            array[i+low]=extra[i];
        }
    }
    //归并排序的非递归写法
    public static void mergeSortNoR(int[] array){
        for(int i=1;i<array.length;i=i*2){
            for(int j=0;j<array.length;j=j+2*i){
                int low=j;
                int mid=j+i;
                int high=mid+i;
                if(mid>=array.length){
                    break;
                }
                if(high>array.length){
                    high=array.length;
                }
                merge(array,low,mid,high);
            }
        }
    }
    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5,6};
        mergeSortNoR(array);
        System.out.println(Arrays.toString(array));
    }
}