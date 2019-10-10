package Practice0916;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/9/17 8:24
 */
public class PrevPermOpt1 {
    //给你一个正整数的数组 A（其中的元素不一定完全不同），
    // 请你返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的、
    // 按字典序排列小于 A 的最大可能排列
    //思路：1）先从后往前找第一个降序的数字，确定了第一个要交换的位置
    //2）再从前往后比它小的数字（这个数字比它小，但是比其他比它小的数字大）
    //3）交换
    public static int[] prevPermOpt1(int[] A) {
        int i=A.length-1;
        while(i>0 && A[i]>=A[i-1]){
            i--;
        }
        i--;
        if(i<0){
            return A;
        }
        int j=i+1;
        int minMax=j;
        while(j<A.length && A[j]<A[i]){
            if(A[minMax]<A[j]){
                minMax=j;
            }
            j++;
        }
        swap(A,i,minMax);
        return A;
    }
    private static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    public static void main(String[] args) {
        int[] array={3,1,1,3};
        System.out.println(Arrays.toString(prevPermOpt1(array)));
    }
}
