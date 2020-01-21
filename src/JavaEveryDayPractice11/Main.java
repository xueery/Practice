package JavaEveryDayPractice11;

import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/18 12:35
 */
public class Main {
    private static int[] countEveryNumber(String string){
        int[] arr=new int[10];
        for(char c:string.toCharArray()){
            switch (c){
                case '0':arr[0]++;break;
                case '1':arr[1]++;break;
                case '2':arr[2]++;break;
                case '3':arr[3]++;break;
                case '4':arr[4]++;break;
                case '5':arr[5]++;break;
                case '6':arr[6]++;break;
                case '7':arr[7]++;break;
                case '8':arr[8]++;break;
                case '9':arr[9]++;break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        int[] arr=countEveryNumber(string);
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0) {
                System.out.println(i + ":" + arr[i]);
            }
        }
    }
}
