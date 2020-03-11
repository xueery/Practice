package JavaEveryDayPractice36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author:wangxue
 * @date:2020/3/6 17:37
 */
public class Solution {
    public int calculateMax(int[] prices) {
        if(prices==null || prices.length<2){
            return 0;
        }
        int len=prices.length;
        int[] left=new int[len];
        left[0]=0;
        int min=prices[0];
        int max=0;
        for(int i=1;i<len;i++){
            if(min>prices[i]){
                min=prices[i];
            }
            if(prices[i]-min>max){
                max=prices[i]-min;
            }
            left[i]=max;
        }
        int[] right=new int[len];
        right[0]=0;
        max=0;
        int high=prices[len-1];
        for(int i=len-2;i>=0;i--){
            if(prices[i]>high) {
                high = prices[i];
            }
            if(high-prices[i]>max){
                max=high-prices[i];
            }
            right[i]=max;
        }
        int result=0;
        for(int i=0;i<len;i++){
            if(result<left[i]+right[i]){
                result=left[i]+right[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        int[] arr={3,8,5,1,7,8};
        System.out.println(s.calculateMax(arr));
    }
}
