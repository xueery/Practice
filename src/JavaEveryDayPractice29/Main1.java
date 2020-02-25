package JavaEveryDayPractice29;

import java.security.SecureRandom;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/6 22:55
 */
public class Main1 {
    public static boolean checkQualified(String s){
        //先判断长度符不符合要求
        if(s.length()<=8){
            return false;
        }
        String[] strings1={"1","2","3","4","5","6","7","8","9","0"};
        String[] strings2={"1","2","3","4","5","6","7","8","9","0"};
        //判断字符串中是否包含大小写字母，数字，其他符号至少三种
        int count=0;
        for(String string:strings1){
            if(s.contains(string)){
                count++;
                break;
            }
        }
        for(int i=0;i<26;i++){
            char c1=(char)(65+i);
            //System.out.println(c1);
            String string1= String.valueOf(c1);
            if(s.contains(string1)){
                count++;
                break;
            }
        }
        for(int i=0;i<26;i++){
            char c2=(char)(97+i);
            String string2= String.valueOf(c2);
            if(s.contains(string2)){
                count++;
                break;
            }
        }
        //判断特殊字符
        for(int i=32;i<48;i++){
            char c=(char)i;
            String s1=String.valueOf(c);
            if(s.contains(s1)){
                count++;
                break;
            }
        }
        if(count<3){
            return false;
        }
        for(int i=0;i<s.length();i++){
            for(int j=i+3;j<s.length();j++){
                String s1=s.substring(i,j);
                String left=s.substring(0,i);
                String right=s.substring(j,s.length());
                if(left.contains(s1)){
                    return false;
                }
                if(right.contains(s1)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            if(checkQualified(s)){
                System.out.println("OK");
            }else{
                System.out.println("NG");
            }
        }
    }
}
