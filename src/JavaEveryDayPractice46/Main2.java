package JavaEveryDayPractice46;
import java.util.*;
/**
 * @author:wangxue
 * @date:2020/3/18 15:41
 */
public class Main2 {
    public static String sumString(String s1,String s2){
        for(char c:s1.toCharArray()){
            System.out.println(c);
        }
        s1=s1.substring(1,s1.length()-1);
        s2=s2.substring(1,s2.length()-1);
        System.out.println(s1);
        System.out.println(s2);
        long a=Long.parseLong(s1);
        long b=Long.parseLong(s2);
        System.out.println(a);
        System.out.println(b);
        long sum=a+b;
        return String.valueOf(sum);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s1=scanner.nextLine();
            String s2=scanner.nextLine();
            System.out.println("\""+sumString(s1,s2)+"\"");
        }
    }
}
