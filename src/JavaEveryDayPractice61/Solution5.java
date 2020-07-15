package JavaEveryDayPractice61;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/15 8:36
 */
// 给你一个链表，每 k 个节点一组进行翻转，请返回翻转后的链表。
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
public class Solution5 {
    public static int[] reverseArray(int[] arr,int n){
        for(int i=0;i<arr.length-n+1;i=i+n){
            swap(arr,i,i+n-1);
        }
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int left=i;
        int right=j;
        while(left<right){
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            String[] strings=s.split(" ");
            int[] arr=new int[strings.length-1];
            for(int i=0;i<strings.length-1;i++){
                arr[i]=Integer.parseInt(strings[i]);
            }
            int n=scanner.nextInt();
            int[] ret=reverseArray(arr,n);
            for(int i=0;i<ret.length;i++){
                if(i!=ret.length-1)
                System.out.print(ret[i]+"->");
                else
                    System.out.print(ret[i]);
            }
        }
    }
}
