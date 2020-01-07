package JavaEveryDayPractice04;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/8 21:14
 */
public class Solution {
    public static String deleteAssignStr(String string,String str){
        if(string.length()==0){
            return null;
        }
        if(str.length()==0){
            return string;
        }
        HashSet<Character> set=new HashSet<>();
        for(char s:str.toCharArray()){
            set.add(s);
        }
        String newString="";
        for(int i=0;i<string.length();i++){
            if(!set.contains(string.charAt(i))){
                newString=newString+string.charAt(i);
            }
        }
        return newString;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String str=scanner.nextLine();
        System.out.println(deleteAssignStr(string,str));
    }
}
