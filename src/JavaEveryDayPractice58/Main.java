package JavaEveryDayPractice58;

/**
 * @author:wangxue
 * @date:2020/6/8 8:51
 */
//拼多多笔试题：利用分治思想求解
import java.util.*;
public class Main{
    public static int calNumber(int num){
        if(num==1) return 1;
        else return 1+calNumber(num/2);
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            int ret=calNumber(scanner.nextInt());
            System.out.println(ret);
        }
    }
}