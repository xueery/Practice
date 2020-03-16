package JavaEveryDayPractice40;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/3/11 12:16
 */
public class Main {
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] nums=new int[n*n];
        int index=0;
        int k=1;
        for(int i=0;i<n;i++) {
            int m=0;
            for (int j = n - k++; j < n; j++) {
                nums[index++] = arr[m++][j];
            }
        }
        for(int i=1;i<n;i++){
            int m=i;
            for(int j=0;j<n-i;j++){
                nums[index++]=arr[m++][j];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[][] arr={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        arrayPrint(arr,4);
    }
}
