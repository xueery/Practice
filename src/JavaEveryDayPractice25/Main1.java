package JavaEveryDayPractice25;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/1 22:53
 */
//解答这道题的难点所在：
// 1)没有考虑A，B是否会越界
// 2）没有想到询问操作时会有A>B的情况
// 3）没有充分理解题意，如果A>B还是取AyuB之间的最高分
public class Main1 {
    public static int searchMaxScore(int[] arr,int A,int B){
        int[] array= Arrays.copyOfRange(arr,A,B+1);
        Arrays.sort(array);
        return array[array.length-1];
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int N=scanner.nextInt();//表示N个学生
            int M=scanner.nextInt();
            scanner.nextLine();//表示M次操作
            int[] arr=new int[N+1];
            for(int i=1;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            for(int i=0;i<M;i++){
                char c=scanner.next().charAt(0);
                int A=scanner.nextInt();
                int B=scanner.nextInt();
                scanner.nextLine();
                if(c=='Q'){
                    if(A<1){
                        A=1;
                    }
                    if(B>N){
                        B=N;
                    }
                    if(A>B){
                        int max=arr[B];
                        for(int j=B;j<=A;j++){
                            if(max<arr[j]){
                                max=arr[j];
                            }
                        }
                        System.out.println(max);
                    }else {
                        //查询在A-B之间成绩最高的分数并返回
                        int max=arr[A];
                        for(int j=A;j<=B;j++){
                            if(max<arr[j]){
                                max=arr[j];
                            }
                        }
                        System.out.println(max);
                    }
                }else {
                    //将学号为A的同学成绩更改为B
                    arr[A]=B;
                }
            }
        }
    }
}
