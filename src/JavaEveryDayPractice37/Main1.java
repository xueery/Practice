package JavaEveryDayPractice37;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/7 16:29
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine().substring(2);
            System.out.println(Integer.parseInt(s,16));
        }
    }
}
