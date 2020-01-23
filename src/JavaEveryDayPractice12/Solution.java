package JavaEveryDayPractice12;

import com.sun.imageio.plugins.common.I18N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:wangxue
 * @date:2019/11/18 13:02
 */
public class Solution {
    public static int[] exchangeAB(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }
    public static List<Integer> getGray(int n) {
        // write code here
        double num=Math.pow(2,n);
        int number=(int)num;
        List<Integer> list=getGrayInternal(number-1);
        return list;
    }

    private static List<Integer> getGrayInternal(int n) {
        List<Integer> ret=new ArrayList<>();
        if(n==-1){
            return new ArrayList<>();
        }else{
            List<Integer> r=getGrayInternal(n-1);
            ret.addAll(r);
            ret.add(n^n/2);
        }
        return ret;
    }

    public static void main(String[] args) {
        //int[] AB={1,2,3};
        //System.out.println(Arrays.toString(exchangeAB(AB)
        List<Integer> list=getGray(4);
        System.out.println(list);
    }
}
