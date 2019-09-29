package Practice0904;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2019/9/5 18:39
 */
public class BrokenKeys {
    public static void main(String[] args) {
        //从键盘上输入： 原本输入的字符和键盘输出的字符（不区分大小写）
        Scanner s=new Scanner(System.in);
        String exceptString=s.nextLine();
        String factString=s.nextLine();
        Set<Character> set=new HashSet<>();
        char[] e=exceptString.toUpperCase().toCharArray();
        char[] f=factString.toUpperCase().toCharArray();
        for(char r:f){
            set.add(r);
        }
        Set<Character> brokenKeys=new HashSet<>();
        for(char r:e){
            if(!set.contains(r)){
                if(!brokenKeys.contains(r)){
                    System.out.println(r);
                    brokenKeys.add(r);
                }
            }
        }
    }
}
