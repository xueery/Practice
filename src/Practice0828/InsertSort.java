package Practice0828;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/28 10:14
 */
public class InsertSort {
    //思路版的插入排序
    //每次把无序区间的第一个数，在有序区间遍历（从后往前遍历）
    //                 1）找到合适的位置
    //                 2）搬移原有数据，为该数据腾出位置
    public static void insertSort1(int[] array){
        for(int i=0;i<array.length-1;i++){
            int key=array[i+1];
            int j;
            //寻找合适的位置
            for(j=i;j>=0;j--){
                if(key>=array[j]){
                    break;
                }
            }
            //搬移原有数据
            for(int k=i;k>j;k--){
                array[k+1]=array[k];
            }
            //把key放进j+1的位置
            array[j+1]=key;
        }
    }
    //缩减版的插入排序
    public static void insertSort2(int[] array){
        for(int i=0;i<array.length-1;i++){
            int key=array[i+1];
            int j;
            for(j=i;j>=0 && key<array[j];j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }

    public static void main(String[] args) {
        int[] array={3,5,1,9,7,0};
        insertSort2(array);
        System.out.println(Arrays.toString(array));
        insertSort1(array);
        System.out.println(Arrays.toString(array));
    }
}
