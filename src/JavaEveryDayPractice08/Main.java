package JavaEveryDayPractice08;

import javax.security.sasl.SaslClient;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/13 22:44
 */
public class Main {
    public static int[] calMinKeyNumber(int[] arr,int k){
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr,0,k);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.split(" ");
        int[] arr=new int[strings.length-1];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(strings[i]);
        }
        int[] a=calMinKeyNumber(arr,Integer.valueOf(strings[strings.length-1]));
        for(int i=0;i<a.length-1;i++){
            System.out.print(a[i]+" ");
        }
        System.out.print(a[a.length-1]);
    }
}
