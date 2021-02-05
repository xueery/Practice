package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/5 11:00
 */
// 选择排序
public class SelectSort {
    public static void selectSort(int[] array){
        int max=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<array.length;i++){
            max=array[0];
            index=0;
            for(int j=1;j<array.length-i;j++){
                if(array[j]>max){
                    max=array[j];
                    index=j;
                }
            }
            swap(array,index,array.length-i-1);
        }
    }

    public static void swap(int[] array,int i,int j){
        int swap=array[i];
        array[i]=array[j];
        array[j]=swap;
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
