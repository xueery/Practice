package Practice1017;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/17 12:20
 */
public class Solution {
    //205:同构字符串
    // 给定两个字符串 s 和 t，判断它们是否是同构的。
    //如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
    //所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。
    // 两个字符不能映射到同一个字符上，但字符可以映射自己本身。
    //输入: s = "egg", t = "add"
    //输出: true
    //输入: s = "foo", t = "bar"
    //输出: false
    public boolean isIsomorphic(String s, String t) {
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        if(arr1.length!=arr2.length){
            return false;
        }
        HashMap<Character,Character> map=new HashMap<>();
        //数组1对应key，数组2对应value
        for(int i=0;i<arr1.length;i++){
            //此if条件检测是否存在map中不存在数组1中的字符，
            // 却存在数组2中与数组1中此字符对应的字符，如果存在则false（多对一）
            if(!map.containsKey(arr1[i])) {
                if(!map.containsValue(arr2[i])) {
                    map.put(arr1[i], arr2[i]);
                }else{
                    return false;
                }
            }
            //此else条件检测是否map中有数组1中的字符，而与之对应的value不是数组2相应位置的字符（一对多）
            else{
               char c=map.get(arr1[i]);
               if(c!=arr2[i]){
                   return false;
               }
            }
        }
        return true;
    }
    //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list=new ArrayList<>();
        while(x>0){
            int a=x%10;
            list.add(a);
            x=x/10;
        }
        for(int i=0;i<list.size()/2;i++){
            if(list.get(i)!=list.get(list.size()-1-i)){
                return false;
            }
        }
        return true;
    }
    //最长公共前缀（如果不存在公共前缀，返回空字符串 ""）
    //输入: ["flower","flow","flight"]
    //输出: "fl"
    public String longestCommonPrefix(String[] strs) {
        return null;
    }
    //给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
    //输入: pattern = "abba", str = "dog cat cat dog"
    //输出: true
    //输入:pattern = "abba", str = "dog cat cat fish"
    //输出: false
    public static boolean wordPattern(String pattern, String str) {
        Map<Character,String> map=new HashMap<>();
        String[] s=str.split(" ");
        if(pattern.length()!=s.length){
            return false;
        }
        int i=0;
        for(char p:pattern.toCharArray()){
            String c=s[i++];
            if(map.containsKey(p)){
                String m=map.get(p);
                if(!(m.equals(c))){
                    return false;
                }
            }else{
                if(map.containsValue(c)){
                    return false;
                }
                map.put(p,c);
            }
        }
        return true;
    }
    //找不同
    //给定两个字符串 s 和 t，它们只包含小写字母。
    //
    //字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
    //
    //请找出在 t 中被添加的字母。
    public char findTheDifference(String s, String t) {
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char e:s1) {
            int count = map1.getOrDefault(e, 0);
            map1.put(e, ++count);
        }
        for(char e:t1) {
            int count = map2.getOrDefault(e, 0);
            map2.put(e, ++count);
        }
        for(Map.Entry<Character,Integer> m:map2.entrySet()){
            char c=m.getKey();
            int n=m.getValue();
            if(!map1.containsKey(c)){
                return c;
            }else{
                int k=map1.get(c);
                if(k!=n){
                    return c;
                }
            }
        }
        return '0';
    }
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    //输入："23"
    //输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    public static List<String> letterCombinations(String digits) {
        List<String>list=new ArrayList<>();
        String[] s=new String[digits.length()];
        if(s.length==0){
            return list;
        }
        //记录输入的每个数字对应的字母，存入字符串数组s中
        for(int i=0;i<digits.length();i++){
            switch (digits.charAt(i)){
                case '2':s[i]="abc";break;
                case '3':s[i]="def";break;
                case '4':s[i]="ghi";break;
                case '5':s[i]="jkl";break;
                case '6':s[i]="mno";break;
                case '7':s[i]="pqrs";break;
                case '8':s[i]="tuv";break;
                case '9':s[i]="wxyz";break;
            }
        }
        list=getStringWithFor(s,0,list,"");
        return list;
    }
    //递归：此方法用来计算对应数字输出的集合
    private static List<String> getStringWithFor(String []s,int i,List<String> list,String stemp) {
        if(i<s.length-1){
            for(int j=0;j<s[i].length();j++){
                list=getStringWithFor(s,i+1,list,stemp+s[i].charAt(j));
            }
            i++;
        } else {
            for(int j=0;j<s[i].length();j++){
                list.add(stemp+s[i].charAt(j));
            }
        }
        return list;
    }
    public static List<String> fizzBuzz(int n) {
        //1. 如果 n 是3的倍数，输出“Fizz”；
        //2. 如果 n 是5的倍数，输出“Buzz”；
        //3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”
        List<String> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0){
                if(i%5==0){
                    list.add("FizzBuzz");
                }else {
                    list.add("Fizz");
                }
            }else if(i%5==0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    //统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
    //请注意，你可以假定字符串里不包括任何不可打印的字符
    public static int countSegments(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            //判断是不是为字符串的第一个字母，或者字符串的前一个是空格 并且当前下标处不是空格则count++
            //计算出的count即为单词个数
            if((i==0 || s.charAt(i-1)==' ') && s.charAt(i)!=' '){
                count++;
            }
        }
        return count;
    }
    //给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    // 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在一个答案
    public static int threeSumClosest(int[] nums, int target) {
        //先对数组进行排序
        Arrays.sort(nums);
        int i=0;
        int k=nums.length-1;
        int j=i+1;
        //record表示和目标数之间差的距离
        //先记录一个target与数组中的三个数相加之后的差的值
        int record=Math.abs(nums[i]+nums[j]+nums[k]-target);
        //ret表示和target最接近的三数之和
        int ret=0;
        while(i<nums.length-2) {
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                //如果这三个数相加之后和target的差值小于记录的那个record则改变record和最接近的值
                if(Math.abs(target-sum)<=record){
                    record=Math.abs(target-sum);
                    ret=sum;
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
            i++;
            j=i+1;
            k=nums.length-1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.isPalindrome(1));
        String t="foo";
        String r="far";
        System.out.println(s.isIsomorphic(t,r));
        String pattern="adda";
        String str="dog cat cat gog";
        System.out.println(wordPattern(pattern,str));
        String str1="23";
        System.out.println(letterCombinations(str1));
        System.out.println(fizzBuzz(15));
        String str2=", , , ,        a, eaefa";
        System.out.println(countSegments(str2));
        int[] arr={0,1,2};
        System.out.println(threeSumClosest(arr,3));
    }
}
