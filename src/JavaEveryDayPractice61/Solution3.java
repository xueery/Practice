package JavaEveryDayPractice61;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/13 9:03
 */
public class Solution3 {
    public static boolean isCorrent(String s){
        String s1=s.toUpperCase();//全部大写
        String s2=s.toLowerCase();//全部小写
        if(s1.equals(s) || s2.equals(s)){
            return true;
        }
        for(int i=0;i<s.length();i++){
            if(i==0){
                if(s.charAt(i)!=s2.charAt(i)-32){
                    return false;
                }
            }else{
                if(s.charAt(i)!=s2.charAt(i)){
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
            if(isCorrent(s)) {
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
