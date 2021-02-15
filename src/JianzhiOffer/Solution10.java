package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/15 20:21
 */
// 矩阵覆盖
public class Solution10 {
    // f[n] = f[n-1] + f[n-2]
    public int rectCover(int target) {
        if (target < 3) return target;
        int n1 = 1;
        int n2 = 2;
        int n = 0;
        for (int i = 3; i <= target; i++) {
            n = n1 + n2;
            n1 = n2;
            n2 = n;
        }
        return n;
    }
}
