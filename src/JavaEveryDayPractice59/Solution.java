package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/16 9:42
 */

public class Solution {
    //剪绳子，得到最大乘积
    //根据分析可得当绳子长度大于4时每次剪3可得到最大乘积
    //当绳子长度等于4，最大乘积为4，小于4的话最大乘积乘积为target-1
    public static int cutRope(int target) {
        if(target<=3 && target>-1){
            return target-1;
        }
        int max=1;
        while(target>4){
            target-=3;
            max*=3;
        }
        return max*target;
    }

    public static void main(String[] args) {
        System.out.println(cutRope(6));
    }
}
