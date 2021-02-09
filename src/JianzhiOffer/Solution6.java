package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/6 11:59
 */
// 旋转数组的最小数字
public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(min>array[i])min=array[i];
        }
        return min;
    }
}
