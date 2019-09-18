package Practice0827;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/8/27 11:23
 */
public class MyPriorityQueue {
    private static int[] array=new int[10];
    private static int size=0;
    public static void add(int element){
        array[size++]=element;
        adjustUp(size-1);
    }
    //时间复杂度O(log(n))
    public static void adjustUp(int index){
        while(index>0){
            int parent=(index-1)/2;
            if(array[parent]<array[index]){
                Heaps.swap(array,index,parent);
            }
            else{
                return;
            }
            index=parent;
        }
    }
    public static int peek(){
        return array[0];
    }
    public static int poll(){
        int e=array[0];
        array[0]=array[--size];
        Heaps.heapify(array,array.length,0);
        return e;
    }
    public static void main(String[] args) {
        add(5);
        add(2);
        add(9);
        add(4);
        add(7);
        add(10);
        System.out.println(size);
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,0,size)));
        System.out.println(peek());
        System.out.println(poll());
        System.out.println(Arrays.toString(Arrays.copyOfRange(array,0,size)));
        System.out.println(size);
    }
}