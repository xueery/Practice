package JavaEveryDayPractice35;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/4 20:19
 */
public class Main {
    public static String checkBrokenKeyBoard(String s1,String s2){
        s1=s1.toUpperCase();
        s2=s2.toUpperCase();
        HashSet<Character> set=new HashSet<>();
        for(char c:s2.toCharArray()){
            set.add(c);
        }
        String s="";
        for(int i=0;i<s1.length();i++){
            if(!set.contains(s1.charAt(i))) {
                if(!s.contains(String.valueOf(s1.charAt(i)))){
                    s+=s1.charAt(i);
                }
            }
        }
        return s;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        System.out.println(checkBrokenKeyBoard(s1,s2));
    }
}
