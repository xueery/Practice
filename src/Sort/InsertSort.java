package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/5 16:21
 */
// 插入排序
public class InsertSort {
    public static void insertSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int j;
            // 找到应该插入的下标位置
            for(j=i+1;j>=0;j--){
                if(array[j]<array[i+1])break;
            }
            // 依次进行交换位置，直到到该插入的位置
            for(int k=i;k>j;k--){
                swap(array,k,k+1);
            }
        }
    }

    public static void swap(int[] array,int i,int j){
        int swap=array[i];
        array[i]=array[j];
        array[j]=swap;
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
