package JavaEveryDayPractice45;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/17 13:55
 */
public class Main {
    public static String changeLanguage(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c=='_'){
                i++;
                c=s.charAt(i);
                sb.append((char)(c-32));
                i++;
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(changeLanguage(s));
        }
    }
}
