package Holiday09;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author:wangxue
 * @date:2020/1/28 11:06
 */
public class Main {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] index=new int[2];
        for(int i=0;i<nums.length;i++){
            int n=target-nums[i];
            if(map.containsKey(n) && map.get(n)!=i){
                index[0]=i;
                index[1]=map.get(n);
                return index;
            }
        }
        return index;
    }
    public String addBinary(String a, String b) {
        int lenA=a.length();
        int lenB=b.length();
        int maxLen=Math.max(lenA,lenB);

        StringBuilder sbA=new StringBuilder(a).reverse();
        StringBuilder sbB=new StringBuilder(b).reverse();
        StringBuilder sb=new StringBuilder();

        while(sbA.length()<maxLen){
            sbA.append('0');
        }
        while(sbB.length()<maxLen){
            sbB.append('0');
        }

        int carry=0;
        for(int i=0;i<maxLen;i++){
            int n1=sbA.charAt(i)-'0';
            int n2=sbB.charAt(i)-'0';

            if(carry+n1+n2>1){
                sb.append(carry+n1+n2-2);
                carry=1;
            }else{
                sb.append(carry+n1+n2);
                carry=0;
            }
        }
        if(carry==1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
