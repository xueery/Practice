package JavaEveryDayPractice60;

/**
 * @author:wangxue
 * @date:2020/6/29 9:18
 */
import java.util.*;
public class Solution5 {
    public static boolean isContinuous(int[] numbers) {
        if(numbers==null || numbers.length==0)return false;
        if(numbers.length!=5) return false;
        Arrays.sort(numbers);
        int num0=0;
        if(numbers[0]==0){
            for(int i=0;i<numbers.length;i++){
                if(numbers[i]==0)num0++;
                else break;
            }
        }
        for(int i=num0;i<numbers.length-1;i++){
            if(numbers[i]==numbers[i+1]) return false;
        }
        if(numbers[4]-numbers[num0]>4)return false;
        return true;
    }

    public static void main(String[] args) {
        int[] numbers={4,6,8,0,0};
        System.out.println(isContinuous(numbers));
    }
}
