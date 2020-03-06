package JavaEveryDayPractice34;

/**
 * @author:wangxue
 * @date:2020/3/3 21:37
 */
public class GoUpstairs {
    public static int countWays(int n) {
        // write code here
        long fn3=1;
        long fn2=2;
        long fn1=4;
        long num=0;
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }else{
            for(int i=4;i<=n;i++){
                num=fn1+fn2+fn3;
                fn1=num;
                fn2=fn1;
                fn3=fn2;
            }
            return (int)(num%1000000007);
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(100000));
    }
}
