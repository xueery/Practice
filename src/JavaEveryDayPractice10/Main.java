package JavaEveryDayPractice10;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/16 13:38
 */
public class Main {
    public static int minFibonacciStep(int num){
        int n=0;
        while(num>Fibonacci(n)){
            n++;
        }
        int high=Fibonacci(n);
        int low=Fibonacci(n-1);
        return Math.min(high-num,num-low);
    }
    private static int Fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println(minFibonacciStep(num));
    }
}
