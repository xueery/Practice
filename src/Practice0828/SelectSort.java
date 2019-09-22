package Practice0828;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/28 11:57
 */
public class SelectSort {
    //直接选择排序
    public static void selectSort(int[] array){
        //无序区间  [0,array.length-i)
        //有序区间  [array.length-i,array.length)
        //每次选最大的数
        for(int i=0;i<array.length-1;i++){
            int max=0;
            for(int j=1;j<array.length-i;j++){
                if(array[max]<array[j]){
                    max=j;
                }
            }
            //交换最大的数和无序空间的最后一个树
            swap(array,max,array.length-i-1);
        }
    }
    //第二种选择排序：记录两个值，一个最大一个最小
    public static void selectSort2(int[] array) {
        for (int left=0, right=array.length-1; left < right; left++, right--) {
            int max=left;
            int min=left;
            for (int i = left+1; i <= right; i++) {
                if (array[i] > array[max]) {
                    max = i;
                }
                if (array[i] < array[min]) {
                    min = i;
                }
            }
            swap(array, left, min);
            if (left == max) {
                max = min;
            }
            swap(array, max, right);
        }
    }
    //堆排序
    public static void heapSort(int[] array){
        creatHeap(array,array.length);
        for(int i=0;i<array.length-1;i++){
            swap(array,0,array.length-i-1);
            //无序区间[0,array.length-i-1)
            //无序数组长度 array.length-i-1
            heapify(array,array.length-i-1,0);
        }
    }
    public static void creatHeap(int[] array,int size){
        //int i=(size-2)/2 最后一个非叶子结点
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }
    public static void heapify(int[] array,int size,int index) {
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[index] > array[max]) {
                return;
            } else {
                swap(array, index, max);
            }
            index = max;
        }
    }
    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }

    public static void main(String[] args) {
        int[] array1={3,4,9,1,0,6};
        selectSort(array1);
        System.out.println(Arrays.toString(array1));
        int[] array2={5,8,3,2,0,5,6,8};
        selectSort2(array2);
        System.out.println(Arrays.toString(array2));
        int[] array3={3,7,0,5,2,8,9,0,1};
        heapSort(array3);
        System.out.println(Arrays.toString(array3));
    }
}
