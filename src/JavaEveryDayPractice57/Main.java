package JavaEveryDayPractice57;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/5/10 13:45
 */
//餐馆
public class Main {
    public static int calMaxMoney(int[] desks,int[][] guests,int n,int m){
        int sum=0;
        Arrays.sort(desks);
        for(int i=0;i<n;i++){
            int index=0;
            int max=0;
            for(int j=0;j<m;j++){
                if(guests[j][0]<=desks[i]){
                    if(guests[j][1]>max){
                        max=guests[j][1];
                        index=j;
                    }
                }
            }
            sum+=max;
            guests[index][0]=Integer.MAX_VALUE;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            int[] desks=new int[n];
            int[][] guests=new int[m][2];
            for(int i=0;i<n;i++){
                desks[i]=scanner.nextInt();
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<2;j++){
                    guests[i][j]=scanner.nextInt();
                }
            }
            System.out.println(calMaxMoney(desks,guests,n,m));
        }
    }
}
