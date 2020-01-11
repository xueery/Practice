package JavaEveryDayPractice06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/11 12:45
 */
public class Main {
    private static int[] checkSugar(int[] arr){
        int[] a=new int[3];
        if(arr[0]+arr[2]%2==0 && arr[1]+arr[3]%2==0) {
            int A = (arr[0] + arr[2]) / 2;
            int B = (arr[1] + arr[3]) / 2;
            int C = A - arr[0] - arr[1];
            if (A >= 0 && B >= 0 && C >= 0) {
                a[0] = A;
                a[1] = B;
                a[2] = C;
                return a;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[4];
        String str=scanner.nextLine();
        String[] strings=str.split(" ");
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(strings[i]);
        }
        if(checkSugar(arr)!=null) {
            int[] a=checkSugar(arr);
            for(int i=0;i<a.length-1;i++){
                System.out.print(a[i]+" ");
            }
            System.out.println(a[2]);
        }else{
            System.out.println("No");
        }
    }
}
