package JavaEveryDayPractice22;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/28 22:59
 */
public class Rabbit {
    public static int countRabbit(int month){
        if(month<3){
            return 1;
        }
        int oldRabbit=1;//有生育能力的兔子
        int youngRabbit=1;//小兔子
        int month1=1;//出生一个月的兔子
        int month2=0;//出生两个月的兔子
        for(int i=4;i<=month;i++){
            oldRabbit+=month2;
            month2=month1;
            month1=oldRabbit;
            youngRabbit=month1+month2;
        }
        return youngRabbit+oldRabbit;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int month = scanner.nextInt();
            System.out.println(countRabbit(month));
        }
    }
}
