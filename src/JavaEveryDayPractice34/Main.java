package JavaEveryDayPractice34;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/3 20:34
 */
public class Main {
    public static int voteMatch(String j,String y){
        if(j.equals(y)){
            return 0;
        }
        switch (j){
            case "C":
                if(y.equals("J")){
                    return 1;
                }else{
                    return -1;
                }
            case "J":
                if (y.equals("B")) {
                    return 1;
                } else {
                    return -1;
                }
            case "B":
                if (y.equals("C")) {
                    return 1;
                } else {
                    return -1;
                }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //下标0,1,2处分别表示胜、平、负的次数
        int[] arrJ=new int[3];
        int[] arrY=new int[3];
        //下标0,1,2处分别表示B、C、J的次数
        int[] arrA=new int[3];
        int[] arrB=new int[3];
        int num=scanner.nextInt();
        scanner.nextLine();
        while(num>0){
            String s=scanner.nextLine();
            String[] strings=s.split(" ");
            if(voteMatch(strings[0],strings[1])==0){
                arrJ[1]++;
                arrY[1]++;
            }else if(voteMatch(strings[0],strings[1])==1){//表示甲获胜
                if(strings[0].equals("B")){
                    arrA[0]++;
                }else if(strings[0].equals("C")){
                    arrA[1]++;
                }else {
                    arrA[2]++;
                }
                arrJ[0]++;
                arrY[2]++;
            }else{
                if(strings[1].equals("B")){
                    arrB[0]++;
                }else if(strings[1].equals("C")){
                    arrB[1]++;
                }else {
                    arrB[2]++;
                }
                arrJ[2]++;
                arrY[0]++;
            }
            num--;
        }
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<3;i++){
            sb1.append(arrJ[i]);
            sb2.append(arrY[i]);
            if(i!=2){
                sb1.append(" ");
                sb2.append(" ");
            }
        }
        System.out.println(sb1);
        System.out.println(sb2);
        int maxA=0;
        int maxB=0;
        for(int i=0;i<3;i++){
            maxA=Math.max(maxA,arrA[i]);
            maxB=Math.max(maxB,arrB[i]);
        }
        if(maxA==arrA[0]){
            System.out.print("B ");
        }else if(maxA==arrA[1]){
            System.out.print("C ");
        }else{
            System.out.print("J ");
        }
        if(maxB==arrB[0]){
            System.out.print("B");
        }else if(maxB==arrB[1]){
            System.out.print("C");
        }else{
            System.out.print("J");
        }
    }
}
