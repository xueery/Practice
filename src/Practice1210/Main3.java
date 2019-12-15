package Practice1210;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/12 21:17
 */
//俄罗斯方块
public class Main3 {
    public static int getScore(int[] arr){
        int score=arr[1];
        for(int i=2;i<arr.length;i++){
            if(arr[i]<score){
                score=arr[i];
            }
        }
        return score;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int col=scanner.nextInt();
            int m=scanner.nextInt();
            scanner.nextLine();
            int[] arr=new int[col+1];
            for(int i=0;i<m;i++){
                int n=scanner.nextInt();
                arr[n]++;
            }
            scanner.nextLine();
            System.out.println(getScore(arr));
        }
    }
}
