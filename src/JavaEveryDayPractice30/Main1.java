package JavaEveryDayPractice30;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/7 21:58
 */
public class Main1 {
    //涉及动态规划，不会写
    public static int countSpecialSum(int[] arr,int sum){
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int sum=scanner.nextInt();
            scanner.nextLine();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(countSpecialSum(arr,sum));
        }
    }
}
