package JavaEveryDayPractice52;
import java.util.*;
/**
 * @author:wangxue
 * @date:2020/3/31 15:59
 */
public class Main1 {
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
        int index=sort(array,left,right);
        quickSortInternal(array,left,index-1);
        quickSortInternal(array,index+1,right);
    }

    private static int sort(int[] array, int left, int right) {
        int index=array[right];
        int min=left;
        int max=right;
        while(min<max){
            while(min<max && index>=array[min]){
                min++;
            }
            while(min<max && index<=array[max]){
                max--;
            }
            int temp=array[min];
            array[min]=array[max];
            array[max]=temp;
        }
        int temp=array[right];
        array[right]=array[min];
        array[min]=temp;
        return min;
    }

    public static void main(String[] args) {
        int[] array={1,7,8,0,5,6,7,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
