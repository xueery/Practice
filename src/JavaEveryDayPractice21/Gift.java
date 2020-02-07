package JavaEveryDayPractice21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/11/27 19:22
 */
public class Gift {
    public static int getValue(int[] gifts, int n) {
        // write code here
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int e:gifts){
            int count=map.getOrDefault(e,0);
            map.put(e,++count);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()>n/2){
                return m.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
