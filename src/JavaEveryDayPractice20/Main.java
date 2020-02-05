package JavaEveryDayPractice20;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/11/27 12:07
 */
public class Main {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] ret=new boolean[p.length];
        for(int i=0;i<ret.length;i++){
            if(s.contains(p[i])){
                ret[i]=true;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        String[] p={"a","b","c","d"};
        System.out.println(Arrays.toString(chkSubStr(p,4,"abc")));

    }
}
