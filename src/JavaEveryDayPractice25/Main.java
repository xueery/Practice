package JavaEveryDayPractice25;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/1 22:39
 */
public class Main {
    public static int calFinallyAbility(int ability,int[] monster){
        int ret=ability;
        for(int i:monster){
            if(i<=ret){
                ret+=i;
            }else{
                ret+=maxNumber(i,ret);
            }
        }
        return ret;
    }
    private static int maxNumber(int i,int j){
        int min=Math.min(i,j);
        for(int k=min;k>=1;k--){
            if(i%k==0 && j%k==0){
                return k;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();
            int ability=scanner.nextInt();
            scanner.nextLine();
            int[] monster=new int[num];
            for(int i=0;i<num;i++){
                monster[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(calFinallyAbility(ability,monster));
        }
    }
}
