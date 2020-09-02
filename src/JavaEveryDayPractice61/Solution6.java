package JavaEveryDayPractice61;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/7/15 8:52
 */

// 输入一个"YYYY-MM-dd"格式的日期字符串，输出该天是当年的第几天（1 月 1 日是每年的第 1 天）
public class Solution6 {

    public static int calDays(int[] array){
        int year=array[0];
        boolean isLeap=false;
        if(year%400==0 || (year%4==0 && year%100!=0)){
            isLeap=true;
        }
        int days=0;
        for(int i=1;i<=array[1];i++){
            if(array[1]==i){
                days+=array[2];
                break;
            }else{
                if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12){
                    days+=31;
                }else if(i==2){
                    if(isLeap) days+=29;
                    else days+=28;
                }else{
                    days+=30;
                }
            }
        }
        return days;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String[] strings=s.split("-");
            int[] arr=new int[3];
            for(int i=0;i<strings.length;i++){
                arr[i]=Integer.parseInt(strings[i]);
            }
            System.out.println(calDays(arr));
        }
    }
}
