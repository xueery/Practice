package JavaEveryDayPractice14;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/20 20:02
 */
public class Main {
    public static String calMinNumber(int[] arr){
        int[] ret=new int[50];
        int index=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                ret[index++]=i;
            }
            max=max+arr[i];
        }
        if(ret[0]==0){
            for(int i=1;i<ret.length;i++){
                if(ret[i]!=0){
                    int tmp=ret[0];
                    ret[0]=ret[i];
                    ret[i]=tmp;
                    break;
                }
            }
        }
        String string="";
        for(int i=0;i<max;i++){
            string+=String.valueOf(ret[i]);
        }
        return string;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.split(" ");
        int[] arr=new int[10];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(strings[i]);
        }
        System.out.println(calMinNumber(arr));
    }
}
