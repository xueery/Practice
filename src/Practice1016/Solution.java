package Practice1016;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2019/10/16 7:55
 */
public class Solution {
    //给定一个整数数组，判断是否存在重复元素。
    // 输入: [1,2,3,1]
    //输出: true
    // 输入: [1,2,3,4]
    //输出: false
    //第一种方法在力扣上编译会出现编译错误
    // 第二种正确
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            int count=map.getOrDefault(num,0);
            map.put(num,++count);
        }
        Collection<Integer> collection=map.values();
        for(int c:collection) {
            if (c != 1) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
       Solution s=new Solution();
       int[] nums={1,1,3,4,5};
        System.out.println(s.containsDuplicate2(nums));
    }
}
