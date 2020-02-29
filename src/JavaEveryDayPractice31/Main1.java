package JavaEveryDayPractice31;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/8 20:45
 */
public class Main1 {
    public static void sortLongString(String[] strings){
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<strings.length-i-1;j++){
                if(compare(strings[j],strings[j+1])){
                    swap(strings,j,j+1);
                }
            }
        }
    }
    private static void swap(String[] strings,int i,int j){
        String tmp=strings[i];
        strings[i]=strings[j];
        strings[j]=tmp;
    }
    //如果字符串s1大，则返回真
    private static boolean compare(String s1,String s2){
        if(s1.length()>s2.length()){
            return true;
        }else if(s1.length()<s2.length()){
            return false;
        }else{
            for(int i=0;i<s1.length();i++){
                if((int)s1.charAt(i)>(int)s2.charAt(i)){
                    return true;
                }else if((int)s1.charAt(i)<(int)s2.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            String[] strings=new String[n];
            for(int i=0;i<n;i++){
                strings[i]=scanner.nextLine();
            }
            sortLongString(strings);
            for(String s:strings){
                System.out.println(s);
            }
        }
    }
}
