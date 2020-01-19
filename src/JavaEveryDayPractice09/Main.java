package JavaEveryDayPractice09;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/14 21:09
 */
public class Main {

    public static int trailingZeroes(int n) {
        int num=n;
        int count = 0;
        while (num >=5) {
            count+=num/5;
            num /= 5;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        System.out.println(trailingZeroes(num));
    }
}
