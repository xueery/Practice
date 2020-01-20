package JavaEveryDayPractice09;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/14 21:32
 */
public class Main1 {
    public static String reverseIntNumber(int num){
        String str="";
        while(num>0){
            int n=num%10;
            str=str+String.valueOf(n);
            num/=10;
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println(reverseIntNumber(num));
    }
}
