package JavaEveryDayPractice39;

/**
 * @author:wangxue
 * @date:2020/3/10 16:21
 */
public class Main {
    public static int getLCA(int a, int b) {
        // write code here
        if(a==b){
            return a;
        }
        if(a>b){
            return getLCA(a/2,b);
        }
        return getLCA(a,b/2);
    }

    public static String replaceSpace(String iniString, int length) {
        // write code here
        String s=iniString.replace(" ","%20");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(getLCA(2,5));
        System.out.println(replaceSpace("Hello World",12));
    }
}
