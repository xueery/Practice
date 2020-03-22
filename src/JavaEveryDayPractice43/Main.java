package JavaEveryDayPractice43;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/13 19:27
 */
public class Main {
    public static int calDay(int year,int month,int day){
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        boolean leap=false;
        if(year%400==0){
            leap=true;
        }
        if(year%4==0 && year%100!=0){
            leap=true;
        }
        int sumDays=0;
        for(int i=1;i<month;i++){
            if(i==2 && leap) {
                sumDays += 1;
            }
            sumDays+=days[i-1];
        }
        sumDays+=day;
        return sumDays;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int year=scanner.nextInt();
            int month=scanner.nextInt();
            int day=scanner.nextInt();
            scanner.nextLine();
            System.out.println(calDay(year,month,day));
        }
    }
}
