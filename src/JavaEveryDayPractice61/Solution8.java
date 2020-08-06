package JavaEveryDayPractice61;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/15 23:18
 */
// 两个负数相乘
public class Solution8 {
    
    public static int[] calComplexNumber(int[] arr1,int[] arr2){
        int n1=arr1[0]*arr2[0];
        int n2=arr1[0]*arr2[1];

        int n3=arr1[1]*arr2[0];
        int n4=arr1[1]*arr2[1];
        int[] ret=new int[2];
        ret[0]=n1-n4;
        ret[1]=n2+n3;
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s1=scanner.nextLine();
            String s2=scanner.nextLine();
            String[] string1=s1.split("\\+");
            String[] string2=s2.split("\\+");
            System.out.println(Arrays.toString(string1));
            System.out.println(Arrays.toString(string2));
            int[] arr1=new int[2];
            int[] arr2=new int[2];
            for(int i=0;i<2;i++){
                if(i==0) {
                    arr1[0]=Integer.parseInt(string1[0]);
                    arr2[0]=Integer.parseInt(string2[0]);
                }else {
                    if(string1[1].length()==1){
                        arr1[1]=1;
                    }else{
                        if((string1[1].substring(0,string1[1].length()-1)).equals("-")){
                            arr1[1]=-1;
                        }else{
                            arr1[1]=Integer.parseInt(string1[1].substring(0,string1[1].length()-1));
                        }
                    }
                    if(string2[1].length()==1){
                        arr2[1]=1;
                    }else{
                        if((string2[1].substring(0,string2[1].length()-1)).equals("-")){
                            arr2[1]=-1;
                        }else{
                            arr2[1]=Integer.parseInt(string2[1].substring(0,string2[1].length()-1));
                        }
                    }

                }
            }
            int[] ret=calComplexNumber(arr1,arr2);
            System.out.println(ret[0]+"+"+ret[1]+"i");
        }
    }
}
