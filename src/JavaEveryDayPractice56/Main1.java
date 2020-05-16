package JavaEveryDayPractice56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author:wangxue
 * @date:2020/4/29 14:58
 */
public class Main1 {
    public static String PrintMinNumber(int [] numbers) {
        String[] strings=new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            strings[i]=String.valueOf(numbers[i]);
        }
        sort(strings);
        return null;
    }

    public static void sort(String[] strings){
        for(int i=0;i<strings.length;i++){
            for(int j=0;j<strings.length-i-1;j++){
                if(compare(strings[j],strings[j+1])>0){
                    String temp=strings[j];
                    strings[j]=strings[j+1];
                    strings[j+1]=temp;
                }
            }
        }
    }
    public static int compare(String s1,String s2){
        int lengthS1=s1.length();
        int lengthS2=s2.length();
        int min=Math.min(lengthS1,lengthS2);
        for(int i=0;i<min;i++){
            int c1=s1.charAt(i);
            int c2=s2.charAt(i);
            if(c1>c2){
                return 1;
            }else if (c1<c2){
                return -1;
            }else{
                return 0;
            }
        }
        if(lengthS1==lengthS2){
            return 0;
        }else if(lengthS1>lengthS2){
            return 1;
        }else {
            return -1;
        }
    }
    public static void main(String[] args) {
        int[] numbers={3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }
}
