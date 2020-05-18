package JavaEveryDayPractice56;

import java.util.ArrayList;

/**
 * @author:wangxue
 * @date:2020/4/28 11:50
 */
public class TopK {
    //找出 k 小的数，建大堆
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input.length<k || k==0){
            return new ArrayList<>();
        }
        int[] topK=new int[k];
        for(int i=0;i<k;i++){
            topK[i]=input[i];
        }
        createBigHeap(topK,topK.length);
        for(int i=k;i<input.length;i++){
            if(topK[0]>input[i]){
                topK[0]=input[i];
                heapifyMax(topK,k,0);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(topK[i]);
        }
        return list;
    }

    public static void createBigHeap(int[] input,int size){
        for(int i=(size-2)/2;i>=0;i--){
            heapifyMax(input,size,i);
        }
    }
    public static void heapifyMax(int[] input,int size,int index){
        if(index>=size) {
            return;
        }
        while(true) {
            int left = 2 * index + 1;
            if (left >= size) {
                return;
            }
            if(left+1<size && input[left]<input[left+1]){
                left=left+1;
            }
            if(input[index]>input[left]){
                return;
            }else{
                swap(input,index,left);
            }
            index=left;
        }
    }

    public static void swap(int[] input,int i,int j){
        int temp=input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={1,5,12,18,9,3,0,8,2,11,15};
        System.out.println(GetLeastNumbers_Solution(arr,5));
    }
}
