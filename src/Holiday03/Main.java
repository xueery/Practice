package Holiday03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2020/1/20 12:40
 */
public class Main {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:magazine.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        for(char c:ransomNote.toCharArray()){
            if(map.containsKey(c)){
                int count=map.get(c);
                if(count==1){
                    map.remove(c);
                }else{
                    map.put(c,--count);
                }
            }else{
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int x){
        if(x<0){
            return false;
        }
        String s=Integer.toString(x);
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }
}
