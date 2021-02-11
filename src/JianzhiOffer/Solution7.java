package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/6 11:57
 */
// 斐波那契
public class Solution7 {
    public static int Fibonacci(int n) {
        if(n==0 || n==1){return n;}
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}
