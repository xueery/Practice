package JavaEveryDayPractice03;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/8 13:39
 */
//读入一个字符串，输出字符串中的最长数字子串
public class Main {
    public static String countMaxNumberStr(String str){
        if(str.length()==0){
            return null;
        }
        int index=0;
        int count=0;
        int i=0;
        int maxIndex=0;
        while(i<str.length()){
            index=i;
            while(i<str.length() && str.charAt(i)>=48 && str.charAt(i)<=57){
                i++;
            }
            if(i-index>count){
                maxIndex=index;
                count=i-index;
            }
            i++;
        }
        return str.substring(maxIndex,maxIndex+count);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        System.out.println(countMaxNumberStr(str));
    }
}
