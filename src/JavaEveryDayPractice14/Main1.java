package JavaEveryDayPractice14;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/20 20:27
 */
public class Main1 {
    //尼科彻斯定理：验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
    //总结规律：首项是m*(m-1)
    public static void GetSequeOddNum(int m){
        int head=m*(m-1)+1;
        System.out.print(head);
        for(int i=1;i<m;i++){
            head+=2;
            System.out.print("+"+head);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int num=scanner.nextInt();
            scanner.nextLine();
            GetSequeOddNum(num);
        }
    }
}
