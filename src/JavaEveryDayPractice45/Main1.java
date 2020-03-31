package JavaEveryDayPractice45;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/17 14:05
 */
public class Main1 {
    public static String reverseStr(String s) {
        s=s.trim();
        char[] chars = s.toCharArray();
        reverseInternal(chars, 0, chars.length);
        StringBuilder sb=new StringBuilder();
        int i = 0;
        int index = 0;
        while (i < chars.length) {
            if (!((chars[i]>='a' && chars[i]<='z') || ((chars[i])>='A' && chars[i]<='Z'))) {
                reverseInternal(chars, index, i);
                sb.append(chars,index,i-index);
                sb.append(" ");
                i++;
                while (i < chars.length && !((chars[i]>='a' && chars[i]<='z') || ((chars[i])>='A' && chars[i]<='Z'))) {
                    i++;
                }
                index = i;
            }
            i++;
        }
        reverseInternal(chars, index, chars.length);
        sb.append(chars,index,chars.length-index);
        return sb.toString().trim();
    }

    private static void reverseInternal(char[] chars, int left, int right) {
        int index=1;
        for(int i=left;i<(left+right)/2;i++){
            char c=chars[i];
            chars[i]=chars[right-index];
            chars[right-index]=c;
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(reverseStr(s));
        }
    }
}
