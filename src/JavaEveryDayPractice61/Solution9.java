package JavaEveryDayPractice61;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/22 21:09
 */
public class Solution9 {
    public static double calPercent(int[] arr,int k){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=arr[k])sum++;
        }
        double ret=((sum-1)/arr.length)*100;
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int sum=scanner.nextInt();
            int[] arr=new int[sum];
            for(int i=0;i<sum;i++){
                arr[i]=scanner.nextInt();
            }
            int num=scanner.nextInt();
            int[] array=new int[num];
            for(int i=0;i<num;i++) {
                array[i]=scanner.nextInt();
            }
            for(int i=0;i<num;i++){
                System.out.printf("%.6f\n",calPercent(arr,array[i]-1));
            }
        }
    }
}
