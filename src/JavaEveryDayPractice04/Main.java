package JavaEveryDayPractice04;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/8 21:03
 */
public class Main {
    public static int countMinBag(int n){
        if(n%8==0){
            return n/8;
        }else{
            int num=n/6;
            for(int i=1;i<=num;i++){
                for(int j=1;j<=num;j++){
                    if(6*i+8*j==n){
                        return i+j;
                    }
                }
            }
        }
        if(n%6==0){
            return n/6;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i=scanner.nextInt();
        scanner.nextLine();
        System.out.println(countMinBag(i));
    }
}
