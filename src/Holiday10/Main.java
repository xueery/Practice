package Holiday10;

import com.sun.imageio.plugins.common.I18N;

import javax.jnlp.IntegrationService;
import java.math.BigInteger;
import java.net.InetAddress;

/**
 * @author:wangxue
 * @date:2020/1/29 15:02
 */
public class Main {
    public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        char[] mychar=str.toCharArray();
        long ans=0;
        int i=0,sign=1,n=str.length();
        while(i<n&&mychar[i]==' ') {
            i++;
        }
        if(i < n &&mychar[i]=='+') {
            i++;
        }else if(i < n &&mychar[i]=='-') {
            i++;
            sign =-1;
        }
        while(i<n&&(mychar[i]>='0'&&mychar[i]<='9')) {
            if(ans!=(int)ans) {
                return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            ans=ans*10+mychar[i++]-'0';
        }

        if(ans!=(int)ans) {
            return (sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }

        return (int)(ans*sign);
    }

    public static int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                int l=mid;
                int r=mid;
                while(l>=0 && nums[l]==target){
                    l--;
                }
                while(r<nums.length && nums[r]==target){
                    r++;
                }
                return new int[]{l,r};
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        //System.out.println(myAtoi("+-2"));
        int[] arr={1,2,3,3,3,3,4,5,9};
        searchRange(arr,3);
    }
}
