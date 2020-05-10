package Holiday18;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2020/2/17 16:05
 */
public class Main {
    //50：第一次出现一次的字符
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        for(char c:s.toCharArray()){
            if(map.get(c)==1){
                return c;
            }
        }
        return '0';
    }

    //53:0～n-1中缺失的数字
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return -1;
    }
}
