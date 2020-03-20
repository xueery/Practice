package JavaEveryDayPractice42;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/12 19:33
 */
public class Main {
    public static int continueArray(int[] arr){
        int max=arr[0];
        int res=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(max+arr[i],arr[i]);
            res=Math.max(res,max);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(continueArray(arr));
        }
    }
}
