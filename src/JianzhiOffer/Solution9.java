package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/6 11:56
 */
// 变态跳台阶
//f[n] = f[n-1] + f[n-2] + ... + f[0]
//f[n-1] = f[n-2] + f[n-3] + ... + f[0]
//f[n] = 2*f[n-1];
//f[0] = f[1]=1;
public class Solution9 {
    public static int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
}

