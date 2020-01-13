package JavaEveryDayPractice07;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/12 19:41
 */
public class Main {
    public static int countMaxCake(int m,int n){
        int[][] arr=new int[m][n];
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //四种情况
                if(i-2>=0){
                    if(arr[i-2][j]==1){
                        continue;
                    }
                }
                if(i+2<m){
                    if(arr[i+2][j]==1){
                        continue;
                    }
                }
                if(j-2>=0){
                    if(arr[i][j-2]==1){
                        continue;
                    }
                }
                if(j+2<n){
                    if(arr[i][j+2]==1){
                        continue;
                    }
                }
                arr[i][j]=1;
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.split(" ");
        int m=Integer.valueOf(strings[0]);
        int n=Integer.valueOf(strings[1]);
        System.out.println(countMaxCake(m,n));
    }
}
