package Practice0904;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2019/9/4 19:18
 */
public class Interview {
    //找出一个数组中只出现一次的数
    public static int singleNumbers(int[] numbers) {
        //先将数组中的数遍历，并统计每个数出现的次数，写入Map中
        Map<Integer,Integer> map=new HashMap<>();
        for(int e:numbers){
            int c=map.getOrDefault(e,0);
            map.put(e,c+1);
        }
        //遍历map寻找只出现一次的数
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int key=e.getKey();
            int value=e.getValue();
            if(value==1){
                return key;
            }
        }
        return -1;
    }
    //找宝石
    public static int numJewelsInStones(String J,String S){
        //J为宝石数组，S为正常数组
        //找S中有几个宝石
        //思路：先将宝石数组中的元素记录在Set中
        Set<Character> set=new HashSet<>();
        for(char c:J.toCharArray()){
            set.add(c);
        }
        //遍历正常数组，找寻宝石
        int count=0;
        for(char c:S.toCharArray()){
            if(set.contains(c)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] numbers={1,3,4,5,5,4,3};
        int ret=singleNumbers(numbers);
        System.out.println(ret);
        String J="aAK";
        String S="ssAaaK";
        int s=numJewelsInStones(J,S);
        System.out.println(s);
    }
}