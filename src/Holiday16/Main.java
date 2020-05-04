package Holiday16;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/2/12 10:03
 */
public class Main {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        //必须要判断k的值是否大于数组的长度，如果大于，返回空数组
        if(k>input.length){
            return list;
        }
        for(int i=0;i<input.length-1;i++){
            int key=input[i+1];
            int j;
            for(j=i;j>=0 && key<input[j];j--){
                input[j+1]=input[j];
            }
            input[j+1]=key;
        }
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr={6,8,9,0,3,4,5,3};
        System.out.println(GetLeastNumbers_Solution(arr,4));
    }
}
