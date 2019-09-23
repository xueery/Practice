package Practice0828;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/28 10:45
 */
public class ShellSort {
    //希尔排序中用到的插入排序
    public static void insertSortWithGap(int[] array,int gap){
        for(int i=0;i<array.length-gap;i++){
            int key=array[i+gap];
            int j;
            for(j=i;j>=0 && key<array[j];j-=gap){
                array[j+gap]=array[j];
            }
            array[j+gap]=key;
        }
    }
    //希尔排序
    public static void shellSort(int[] array){
        int gap=array.length;
        while(true){
            gap=gap/3+1;
            insertSortWithGap(array,gap);
            if(gap==1){
                return;
            }
        }
    }
    public static void main(String[] args) {
        int[] array={1,7,8,9,0,3,4,5,6,2};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}