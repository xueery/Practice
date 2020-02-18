package JavaEveryDayPractice26;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/3 22:43
 */
public class Main {
    public static double calGPA(int n,int[] score,int[] scoreReally){
        double sum=0;
        for(int i=0;i<n;i++){
            if(scoreReally[i]>=90 && scoreReally[i]<=100){
                sum+=4.0*score[i];
            }else if(scoreReally[i]>=85 && scoreReally[i]<=89){
                sum+=3.7*score[i];
            }else if(scoreReally[i]>=82 && scoreReally[i]<=84){
                sum+=3.3*score[i];
            }else if(scoreReally[i]>=78 && scoreReally[i]<=81){
                sum+=3.0*score[i];
            }else if(scoreReally[i]>=75 && scoreReally[i]<=77){
                sum+=2.7*score[i];
            }else if(scoreReally[i]>=72 && scoreReally[i]<=74){
                sum+=2.3*score[i];
            }else if(scoreReally[i]>=68 && scoreReally[i]<=71){
                sum+=2.0*score[i];
            }else if(scoreReally[i]>=64 && scoreReally[i]<=67){
                sum+=1.5*score[i];
            }else if(scoreReally[i]>=60 && scoreReally[i]<=63){
                sum+=1.0*score[i];
            }else{
                sum+=0;
            }
        }
        int sumScore=0;
        for(int i=0;i<score.length;i++){
            sumScore+=score[i];
        }
        return sum/sumScore;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] score=new int[n];
        int[] scoreReally=new int[n];
        for (int i=0;i<n;i++){
            score[i]=scanner.nextInt();
        }
        scanner.nextLine();
        for(int i=0;i<n;i++){
            scoreReally[i]=scanner.nextInt();
        }
        scanner.nextLine();
        System.out.printf("%.2f",calGPA(n,score,scoreReally));
    }
}
