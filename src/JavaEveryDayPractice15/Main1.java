package JavaEveryDayPractice15;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/21 20:21
 */
public class Main1 {
    /**
     *
     * @param num 刚开始所在的位置
     * @return
     */
    //看不懂答案
    private static int calMinStep(long num){
        //贝壳所在地
        return calMinStepInternal(num,1);
    }
    private static int calMinStepInternal(long num,int i){
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long num=scanner.nextLong();
        System.out.println(calMinStep(num));
    }
}
