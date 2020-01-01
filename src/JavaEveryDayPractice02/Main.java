package JavaEveryDayPractice02;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/6 22:54
 */
public class Main {
    public static int mostSodaWater(int num){
        int count=0;
        while(num>=2){
            //兑换的可乐
            int m=num/3;
            count=count+m;
            //兑换之后剩余的空瓶子
            int n=num%3;
            if(n==2 && m==0){
                count++;
                return count;
            }
            num=m+n;
        }
        return count;
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[10];
        int index=0;
        int m=0;
        while(scanner.hasNext() &&(m=scanner.nextInt())!=0){
            scanner.nextLine();
            arr[index++]=mostSodaWater(m);
        }

        for(int i=0;i<index;i++){
            System.out.println(arr[i]);
        }
        //System.out.println(mostSodaWater(10));
    }
}
