package JavaEveryDayPractice13;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/20 13:13
 */
public class Main1 {
    public BigInteger addLongInterger(String addend,String augend){
        BigInteger integer1=new BigInteger(addend);
        BigInteger integer2=new BigInteger(augend);
        return integer1.add(integer2);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Main1 main=new Main1();
        String string1=scanner.nextLine();
        String string2=scanner.nextLine();
        System.out.println(main.addLongInterger(string1,string2));
    }
}
