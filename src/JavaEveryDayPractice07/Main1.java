package JavaEveryDayPractice07;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/12 19:46
 */
public class Main1 {
    public static int calMinCommonMultiple(int m,int n){
        if(m<n){
            int tmp=m;
            m=n;
            n=tmp;
        }
        for(int i=1;i<n;i++){
           if((m*i)%n==0){
               return m*i;
           }
        }
        return m*n;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int m=scanner.nextInt();
        scanner.nextLine();
        int n=scanner.nextInt();
        scanner.nextLine();
        System.out.println(calMinCommonMultiple(m,n));
    }
}
