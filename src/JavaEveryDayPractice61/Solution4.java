package JavaEveryDayPractice61;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/13 9:14
 */
public class Solution4 {
    public static BigInteger twoNumberMul(String s1,String s2){
        BigInteger n1=new BigInteger(s1);
        BigInteger n2=new BigInteger(s2);
        return n1.multiply(n2);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s1=scanner.nextLine();
            String s2=scanner.nextLine();
            System.out.println(twoNumberMul(s1,s2));
        }
    }
}
