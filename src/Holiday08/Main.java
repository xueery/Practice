package Holiday08;

import java.math.BigInteger;
import java.util.*;

/**
 * @author:wangxue
 * @date:2020/1/27 13:21
 */
public class Main {
    public static int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]!=9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] ret=new int[digits.length+1];
        ret[0]=1;
        return ret;
    }

    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int[] ret=new int[nums.length];
        int index=0;
        Iterator<Integer> it=set.iterator();
        while (it.hasNext()){
            ret[index++]=it.next();
        }
        Arrays.sort(ret);
        if(set.size()<3){
            return ret[ret.length-1];
        }
        return ret[ret.length-3];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        plusOne(arr);
    }
}
