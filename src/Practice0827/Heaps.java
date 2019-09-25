package Practice0827;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/27 10:05
 */
public class Heaps {
    //array 被看作堆的数组
    // size 数组中被看作堆的值的个数
    // index 要调整位置的下标
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
    public static void heapifyMin(int[] array,int size,int index){
        while(true){
            int left=2*index+1;
            if(left>=size){
                return;
            }
            int min=left;
            if(left+1<size && array[left]>array[left+1]){
                min=left+1;
            }
            if(array[index]>array[min]){
                swap(array,index,min);
            }else{
                return;
            }
            index=min;
        }
    }
    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    //建大顶堆 复杂度准确来说为O(n)
    public static void creatHeap(int[] array,int size){
        //int i=(size-2)/2 最后一个非叶子结点
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }
    //建小顶堆
    public static void creatSmallHeap(int[] array,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapifyMin(array,size,i);
        }
    }
    public static void main(String[] args) {
        int[] array={-1,8,4,6,7,2,3,1,0};
        heapify(array,array.length,0);
        System.out.println(Arrays.toString(array));
        int[] array1={3,5,2,4,9,0,1,9,8,4,7,2,3,8,6,3};
        creatHeap(array1,array1.length);
        System.out.println(Arrays.toString(array1));
    }
}