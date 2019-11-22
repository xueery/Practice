package Practice1020;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author:wangxue
 * @date:2019/10/20 14:05
 */
public class Solution {
    public static void reverseString(char[] s) {
        for(int i=0;i<s.length/2;i++){
            swap(s,i,s.length-i-1);
        }
    }
    private static void swap(char[] s, int i, int j) {
        char tmp=s[i];
        s[i]=s[j];
        s[j]=tmp;
    }
    //编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
    //元音字母：a、e、i、o、u(注意还有大写字母)
    public static String reverseVowels(String s) {
        HashSet<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char[] arr=s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j) {
            while (i < j && !set.contains(arr[i])) {
                i++;
            }
            while (i < j && !set.contains(arr[j])) {
                j--;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        String str="";
        for(int k=0;k<arr.length;k++){
            str=str+arr[k];
        }
        return str;
    }
    public static void main(String[] args) {
        char[] arr={'h','e','l','l','o'};
        reverseString(arr);
        System.out.println(arr);
        String s="hello";
        System.out.println(reverseVowels(s));
    }
}
