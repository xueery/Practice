package JavaEveryDayPractice28;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/5 22:39
 */
public class Main {
    public static int searchNumber(int[] arr,int num){
        for(int i=0;i<arr.length;i++){
            if(num==arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            int num=scanner.nextInt();
            scanner.nextLine();
            System.out.println(searchNumber(arr,num));
        }
    }
}
