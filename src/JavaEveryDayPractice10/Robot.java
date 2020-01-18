package JavaEveryDayPractice10;

/**
 * @author:wangxue
 * @date:2019/11/16 13:59
 */
public class Robot {
    private static int row=0;//行
    private static int col=0;//列
    public static int countWays(int x, int y) {
        // write code here
        int down=0;
        int right=0;
        if(row==x){
            if(col!=y) {
                return 1;
            }else{
                return 0;
            }
        }
        if(col==y){
            return 1;
        }
        if(row!=x && col!=y){
            right=countWays(x-1,y);
            down=countWays(x,y-1);
        }
        return right+down;
    }

    public static void main(String[] args) {
        System.out.println(countWays(2,2));
    }
}


