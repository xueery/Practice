package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/16 23:03
 */
import java.util.*;
// 丑数
public class Solution2 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0)return 0;
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        int n2=0,n3=0,n5=0;
        while(list.size()<index){
            int m2=list.get(n2)*2;
            int m3=list.get(n3)*3;
            int m5=list.get(n5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2) n2++;
            if(min==m3) n3++;
            if(min==m5) n5++;
        }
        return list.get(list.size()-1);
    }

}
