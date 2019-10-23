package Practice0923;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/9/25 8:28
 */
public class CreatHeap {
    public void heapify(int[] array,int size,int index){
        while(true) {
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
            }
            swap(array, index, max);
            index = max;
        }
    }
    public void creatHeap(int[] array,int size){
        //最后一个非叶子结点
        for(int i=(size-2)/2;i>=0;i--){
            heapify(array,size,i);
        }
    }
    private void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    public static void main(String[] args) {
        int[] array={3,5,2,4,9,0,1,9,8,4,7,2,3,8,6,3};
        CreatHeap heap=new CreatHeap();
        heap.creatHeap(array,array.length);
        System.out.println(Arrays.toString(array));
    }
}
