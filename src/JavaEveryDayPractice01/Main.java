package JavaEveryDayPractice01;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/5 19:26
 */
public class Main {
    private static int countPalindromeString(String string,String str){
        if(str.length()==0){
            if(palindromeString(string)){
                return 1;
            }
        }
        int count=0;
        for(int i=0;i<=string.length();i++){
            String head=string.substring(0,i);
            String last=string.substring(i,string.length());
            String strings=head+str+last;
            if(palindromeString(strings)){
                count++;
            }
        }
        return count;
    }

    private static boolean palindromeString(String strings) {
        for(int i=0;i<strings.length()/2;i++){
            if(strings.charAt(i)!=strings.charAt(strings.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //注意：牛客网上自己写整个程序不允许输出自己想输出的字符，只能输出结果
        System.out.println("输入第一个字符串");
        String string=scanner.nextLine();
        System.out.println("输入第二个字符串");
        String str=scanner.nextLine();
        int num=countPalindromeString(string,str);
        System.out.println(num);
    }
}
