package JavaEveryDayPractice61;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/7 8:58
 */
public class Solution1 {
    //  网易  吃葡萄
    public static int calMaxNumber(int[] arr){
        int sum=arr[0]+arr[1]+arr[2];
        //
        return Math.max((sum+2)/3,(arr[2]+1)/2);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sum=scanner.nextInt();
        for(int k=0;k<sum;k++) {
            int[] arr = new int[3];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            System.out.println(calMaxNumber(arr));
        }
    }
}
