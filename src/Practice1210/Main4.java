package Practice1210;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/13 18:28
 */
public class Main4 {
    //主要思路：重复的次数和字符串长度一样
    public static int howManyBills(String s){
        int length=s.length();
        return (length+1)*26-length;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(howManyBills(s));
        }
    }
}
