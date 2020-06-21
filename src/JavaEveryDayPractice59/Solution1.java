package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/16 10:17
 */
import java.util.*;
public class Solution1 {
    public static int GetUglyNumber_Solution(int index) {
        int count=0;
        int num=1;
        while(true){
            if(index>count){
                if(isUglyNumber(num)){
                    count++;
                    if(index==count){
                        return num;
                    }
                }
                num++;
            }
        }
    }
    public static Boolean isUglyNumber(int num){
        HashSet<Integer> set=new HashSet<>();
        for(int i=2;i<=num/2+1;i++){
            for(int j=num/2+1;j>=2;j--){
                if(i*j==num){
                    if(i%2==1){
                        set.add(i);
                    }
                    if(j%2==1){
                        set.add(i);
                    }
                }
                break;
            }
        }
        for(int i:set){
            if(i!=2 && i!=3 && i!=5){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(4));
    }
}
