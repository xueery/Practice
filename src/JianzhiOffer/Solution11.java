package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/15 20:22
 */
//二进制中 1 的个数
public class Solution11 {
    public int NumberOf1(int n) {
        String s=Integer.toBinaryString(n);
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')count++;
        }
        return count;
    }
}
