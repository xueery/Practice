package Practice0920;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/9/20 17:03
 */
public class Solution {
    //反转字符串
    public int reverse(int x) {
        double num=0;
        if(x>0){
           while(x>0){
               int m=x%10;
               num=num*10+m;
               x=x/10;
           }
        }else if(x<0){
           int s=-x;
           while(s>0){
               int m=s%10;
               num=num*10+m;
               s=s/10;
           }
           num=-num;
        }else {
            return 0;
        }
        int min=-2147483648;
        int max=2147483647;
        if(num >= min && num <= max) {
            return (int)num;
        }
        return 0;
    }
    //两树之和
    public int[] twoSum(int[] nums, int target) {
        int[] array=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    array[0]=i;
                    array[1]=j;
                    return array;
                }
            }
        }
        return array;
    }
    //合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] array=new int[m+n];
        int i=0;
        int j=0;
        int arrayi=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                array[arrayi++]=nums1[i++];
            }else{
                array[arrayi++]=nums2[j++];
            }
        }
        while(i<m){
            array[arrayi++]=nums1[i++];
        }
        while(j<n){
            array[arrayi++]=nums2[j++];
        }
        for(int k=0;k<array.length;k++){
            nums1[k]=array[k];
        }
    }
    public static int romanToInt(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',500);
        int n=0;
        Map<Character,List<Character>> special=new HashMap<>();
        special.put('I',Arrays.asList('V','X'));
        special.put('X',Arrays.asList('L','C'));
        special.put('C',Arrays.asList('D','M'));
        for(int i=0;i<s.length();i++){
            char e=s.charAt(i);
            if(i<s.length()-1) {
                char next=s.charAt(i+1);
                if(special.containsKey(e)){
                    if(special.get(e).contains(next)){
                        int r=map.get(next);
                        int t=map.get(e);
                        int sum=r-t;
                        n+=sum;
                        i++;
                        continue;
                    }
                }
            }
            n+=map.get(e);
        }
        return n;
    }
    public static void main(String[] args) {
        int x=1534236469;
        Solution s=new Solution();
        System.out.println(s.reverse(x));
        int[] nums={2,7,11,15};
        System.out.println(Arrays.toString(s.twoSum(nums,9)));
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        int m=3;
        int n=3;
        s.merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
        String t="VI";
        System.out.println(romanToInt(t));
    }
}