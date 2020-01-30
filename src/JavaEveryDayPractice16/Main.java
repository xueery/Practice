package JavaEveryDayPractice16;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/22 23:16
 */
public class Main {
    public static int countScoreNumber(int num,String string,int score){
        String[] strings=string.split(" ");
        int sum=0;
        for(String s:strings){
            if(score==Integer.valueOf(s)){
                sum++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();
            scanner.nextLine();
            if(num==0)break;
            String string=scanner.nextLine();
            int score=scanner.nextInt();
            scanner.nextLine();
            System.out.println(countScoreNumber(num,string,score));
        }
    }
}
