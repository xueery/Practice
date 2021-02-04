package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/4 21:52
 */
// 冒泡排序
public class BubbleSort {
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
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
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
