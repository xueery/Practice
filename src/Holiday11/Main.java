package Holiday11;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/1/30 11:42
 */
public class Main {
    public static boolean isPalindrome(String s) {
        if(s==null || s.length()==0){
            return true;
        }
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            while(i<=j && !((s.charAt(i)>='0' && s.charAt(i)<='9')||(s.charAt(i)>='a' && s.charAt(i)<='z'))){
                i++;
            }
            while(i<=j && !((s.charAt(j)>='0' && s.charAt(j)<='9')||(s.charAt(j)>='a' && s.charAt(j)<='z'))){
                j--;
            }
            if(i>j){
                return true;
            }
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static int compress(char[] chars) {
        int count=1;
        int index=0;
        char cur=chars[0];
        for(int i=1;i<chars.length;i++){
            if(cur==chars[i]){
                count++;
            }else{
                index=add(chars,count,index,cur);
                cur=chars[i];
                count=1;
            }
        }
        index=add(chars,count,index,cur);
        return index;
    }
    private static int  add(char[] chars,int count,int index,char cur){
        if(count==1){
            chars[index++]=cur;
        }else{
            StringBuilder s=new StringBuilder();
            chars[index++]=cur;
            while(count!=0){
                int n=count%10;
                s.append((char)(n+'0'));
                count/=10;
            }
            String ss=s.reverse().toString();
            for(char c:ss.toCharArray()){
                chars[index++]=c;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        //System.out.println(isPalindrome(""));
        char[] chars={'a','b','b','b','b','b','b','b','b','b','b','b','b','c'};
        System.out.println(compress(chars));
    }
}
