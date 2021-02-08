package Sort;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2021/2/6 11:50
 */
// 堆排序

// 堆排序的基本思想是：
// 将待排序序列构造成一个大顶堆，
// 此时，整个序列的最大值就是堆顶的根节点。
// 将其与末尾元素进行交换，此时末尾就为最大值。
// 然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。
// 如此反复执行，便能得到一个有序序列了
public class HeapSort {
    public static void heapSort(int[] array){
        // 先建大顶堆
        for(int i=(array.length-1)/2;i>=0;i--){
            adjust(array,i,array.length);
        }

        // 再每次调整
        for(int i=array.length-1;i>=0;i--){
            // 交换末尾元素和大顶堆的堆顶的最大值元素
            swap(array,0,i);
            // 再将剩余的元素重新排成一个大顶堆
            adjust(array,0,i);
        }
    }

    public static void adjust(int[] array,int parent,int length){
        // 定义左孩子下标
        int lchild=2*parent+1;
        while (lchild<length){
            // 右孩子下标
            int rchild=lchild+1;
            // 如果右孩子下标没有越界 并且 右孩子的值大于左孩子  lchild++
            if(rchild<length && array[lchild]<array[rchild]){
                lchild++;
            }
            // 如果父节点的值大于孩子的值，则跳出循环
            if(array[parent]>=array[lchild])break;
            // 如果不大于，则交换父节点和孩子的值
            swap(array,parent,lchild);
            // 向下继续遍历
            parent=lchild;
            lchild=2*lchild+1;
        }
    }

    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void main(String[] args) {
        int[] array={1,5,2,8,9,3,0,8,2,1,5};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
