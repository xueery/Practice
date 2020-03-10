package JavaEveryDayPractice36;

/**
 * @author:wangxue
 * @date:2020/3/6 17:26
 */
public class Main {
    public static void main(String[] args) {
        int rich=10;
        int pool;
        rich=rich*30;
        pool=(1-(int)Math.pow(2,30))/(1-2);
        System.out.printf("%d %d",rich,pool);
    }
}
