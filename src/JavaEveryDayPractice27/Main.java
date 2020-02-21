package JavaEveryDayPractice27;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/5 16:39
 */
public class Main {
    public static int[] calEverySum(int n){
        int num=n;
        int sum=0;
        int powSum=0;
        while(num!=0){
            sum+=(num%10);
            num/=10;
        }
        int pow=(int)Math.pow(n,2);
        int num1=pow;
        while(num1!=0){
            powSum+=(num1%10);
            num1/=10;
        }
        int[] ret=new int[2];
        ret[0]=sum;
        ret[1]=powSum;
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=calEverySum(n);
            System.out.print(arr[0]+" "+arr[1]);
            System.out.println();
        }
    }
}
