package JavaEveryDayPractice11;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/11/18 12:51
 */
public class Solution {
    public static int[] multiply(int[] A) {
        int[] B=new int[A.length];
        for(int i=0;i<B.length;i++){
            B[i]=1;
            for(int j=0;j<A.length;j++){
                if(j!=i) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A={1,2,3};
        System.out.println(Arrays.toString(multiply(A)));
    }
}
