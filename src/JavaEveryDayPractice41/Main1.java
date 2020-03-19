package JavaEveryDayPractice41;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/12 13:32
 */
public class Main1 {
    public static String reverse(String s){
        char[] chars=s.toCharArray();
        reverseInternal(chars,0,s.length());
        System.out.println(Arrays.toString(chars));
        int index=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                reverseInternal(chars,index,i);
                index=i+1;
            }
        }
        reverseInternal(chars,index,s.length());
        s=new String(chars);
        return s;
    }
    public static void reverseInternal(char[] chars,int start,int end){
        int index=1;
        for(int i=start;i<(start+end)/2;i++){
            char c=chars[i];
            chars[i]=chars[end-index];
            chars[end-index]=c;
            index++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(reverse(s));
        }
    }
}
