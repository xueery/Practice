package JavaEveryDayPractice02;

/**
 * @author:wangxue
 * @date:2019/11/6 19:58
 */
public class Solution {
    public static int count(int[] A, int n) {
        // write code here
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(A[i]<A[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,0};
        System.out.println(count(arr,arr.length));
    }
}
