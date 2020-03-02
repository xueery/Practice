package JavaEveryDayPractice32;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/1 19:30
 */
public class Main {
    public static String reverse(String s){
        char[] chars=s.toCharArray();
        reverseStr(chars,0,chars.length);
        int first=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                reverseStr(chars,first,i);
                first=i+1;
            }
        }
        reverseStr(chars,first,chars.length);
        String str=new String(chars);
        return str;
    }
    private static void reverseStr(char[] chars,int left,int right){
        int index=1;
        for(int i=left;i<(left+right)/2;i++){
            swap(chars,i,right-(index++));
        }
    }
    private static void swap(char[] chars,int i,int j){
        char c=chars[i];
        chars[i]=chars[j];
        chars[j]=c;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(reverse(s));
        }
    }
}
