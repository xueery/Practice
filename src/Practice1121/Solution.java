package Practice1121;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author:wangxue
 * @date:2019/11/21 16:43
 */
public class Solution {
    //没有实现
    public static int twoCitySchedCost(int[][] costs) {
        int[] A=new int[costs.length];
        int[] B=new int[costs.length];
        int aIndex=0;
        int bIndex=0;
        int sum=0;
        for(int i=0;i<costs.length;i++){
            if(costs[i][0]<costs[i][1]){
                A[aIndex++]=costs[i][0];
                sum+=costs[i][0];
            }else{
                B[bIndex++]=costs[i][1];
                sum+=costs[i][1];
            }
        }
        if(aIndex!=bIndex){

        }
        return sum;
    }
    //查询后的偶数和
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ret=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int index=queries[i][1];
            int val=queries[i][0];
            A[index]+=val;
            int sum=0;
            for(int e:A){
                if(e%2==0){
                    sum+=e;
                }
            }
            ret[i]=sum;
        }
        return ret;
    }
    //替换空格
    public static String replaceSpace(StringBuffer str) {
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                str=str.replace(i,i+1,"10%");
            }
        }
        return str.toString();
    }
    public static boolean isMonotonic(int[] A) {
        int[] copyA=new int[A.length];
        for(int i=0;i<A.length;i++){
            copyA[i]=A[i];
        }
        Arrays.sort(copyA);
        if(A[0]-A[A.length-1]<=0) {
            for (int i = 0; i < A.length; i++) {
                if (copyA[i] != A[i]) {
                    return false;
                }
            }
        }else{
            for (int i = A.length-1; i>=0; i--) {
                if (copyA[i] != A[A.length-i-1]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] costs={{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCitySchedCost(costs));
        System.out.println(replaceSpace(new StringBuffer("wang xue yuan")));
        int[] A={1,2,3,4};
        int[][] queries={{1,0},{-3,1},{-4,0},{2,3}};
        System.out.println(Arrays.toString(sumEvenAfterQueries(A,queries)));
        int[] arr={6,5,4,4};
        System.out.println(isMonotonic(arr));
    }
}
