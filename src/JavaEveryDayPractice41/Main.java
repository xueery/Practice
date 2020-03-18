package JavaEveryDayPractice41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/12 13:08
 */
public class Main {
    public static String deleteCommonCharacter(String s,String str){
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            String string=String.valueOf(c);
            if(!str.contains(string)){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String str=scanner.nextLine();
            System.out.println(deleteCommonCharacter(s,str));
        }
    }
}
