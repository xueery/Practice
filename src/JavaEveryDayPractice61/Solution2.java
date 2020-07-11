package JavaEveryDayPractice61;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/9 9:02
 */
public class Solution2 {
    public static int calMaxLength(int[] arr,int n){
        int left=0;
        int right=1;
        int maxLength=1;
        int curLength=1;
        int sumNumber=arr[0];
        while(right<arr.length){
            if(arr[right]>sumNumber){
                sumNumber+=arr[right];
                curLength=right-left+1;
                right++;
                maxLength = maxLength > curLength ? maxLength : curLength;
            }else{
                sumNumber-=arr[left];
                left++;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        for(int i=0;i<num;i++){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int j=0;j<n;j++){
                arr[j]=scanner.nextInt();
            }
            System.out.println(calMaxLength(arr,n));
        }
    }
}
