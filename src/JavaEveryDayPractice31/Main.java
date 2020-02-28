package JavaEveryDayPractice31;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/8 20:20
 */
public class Main {
    public static String[] parityCheck(String s){
        String[] strings=new String[s.length()];
        for(int j=0;j<s.length();j++){
            int n=(int)s.charAt(j);
            String string=Integer.toBinaryString(n);
            StringBuilder stringBuilder=new StringBuilder();
            if(string.length()<8) {
                for(int i=0;i<8-string.length();i++){
                    stringBuilder.append("0");
                }
                stringBuilder.append(string);
                string=stringBuilder.toString();
            }
            int count=0;
            for(char c:string.toCharArray()){
                if(c=='1'){
                    count++;
                }
            }
            if(count%2==0){
                stringBuilder=new StringBuilder();
                stringBuilder.append("1");
                stringBuilder.append(string.substring(1,string.length()));
            }
            strings[j]=stringBuilder.toString();
        }
        return strings;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String[] strings=parityCheck(s);
            for(int i=0;i<strings.length;i++){
                System.out.println(strings[i]);
            }
        }
    }
}
