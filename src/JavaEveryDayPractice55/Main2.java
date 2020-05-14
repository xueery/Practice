package JavaEveryDayPractice55;

/**
 * @author:wangxue
 * @date:2020/4/25 15:10
 */
import java.util.*;
public class Main2{
    public static void calNumber(int[] arr,int n){
        for(int i=0;i<n;i++){
            int min=arr[i];
            int left=-1;
            int right=-1;
            for(int j=i-1;j>=0;j--){
                if(arr[j]<min){
                    left=j;
                    break;
                }
            }
            for(int j=i+1;j<n;j++){
                if(arr[j]<min){
                    right=j;
                    break;
                }
            }
            System.out.println(left+" "+right);
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            calNumber(arr,n);
        }
    }
}