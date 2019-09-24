package Practice0829;

import java.util.Arrays;

import static Practice0828.SelectSort.swap;

/**
 * @author:wangxue
 * @date:2019/8/29 10:23
 */
public class BubbleSort {
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            boolean sort=true;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                    sort=false;
                }
            }
            if(sort==true){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array={3,4,8,7,0,1,7};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}

