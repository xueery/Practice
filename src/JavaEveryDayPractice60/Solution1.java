package JavaEveryDayPractice60;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2020/6/23 20:26
 */
public class Solution1 {
    // 求 1+2+...+n 不能使用for，while等判断语句
    // 思路：利用短路求值
    public int Sum_Solution(int n) {
        int ans = n;
        boolean flag=(ans!=0) && ((ans+=Sum_Solution(n-1))!=0);
        return ans;
    }
}
