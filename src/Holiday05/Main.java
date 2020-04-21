package Holiday05;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/1/22 10:31
 */
public class Main {
    public boolean containsDuplicate1(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            int count=map.getOrDefault(i,0);
            map.put(i,++count);
        }
        for(int i:map.values()){
            if(i!=1){
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //925:长按键入
    public boolean isLongPressedName(String name, String typed) {
         int j=0;
         for(char c:name.toCharArray()){
             if(j==typed.length()){
                 return false;
             }
             if(c!=typed.charAt(j)){
                 if(j==0 || typed.charAt(j-1)!=typed.charAt(j)){
                     return false;
                 }
                 char cur=typed.charAt(j);
                 while(j<typed.length() && typed.charAt(j)==cur){
                     j++;
                 }
                 if(j==typed.length() || typed.charAt(j)!=c){
                     return false;
                 }
             }
             j++;
         }
         return true;
    }
}
