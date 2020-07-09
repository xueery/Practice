package JavaEveryDayPractice61;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/7 8:34
 */
public class Solution {
    // 网易
    // 定义S(n)，表示n在十进制下的各位数字和。
    // 现在给定一个x,请你求出最小正整数n，满足x<=S(n)
    public static String[] calMinNumber(int[] arr,int n){
        String[] ret=new String[n];
        for(int i=0;i<n;i++){
            int m=arr[i]/9;
            int k=arr[i]%9;
            StringBuilder sb=new StringBuilder();
            sb.append(k);
            for(int j=0;j<m;j++){
                sb.append(9);
            }
            ret[i]=sb.toString();
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        String[] ret=calMinNumber(arr,n);
        for(String s:ret){
            System.out.println(s);
        }
    }
}
