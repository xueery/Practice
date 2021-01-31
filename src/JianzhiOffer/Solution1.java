package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/1/31 22:16
 */
// 二维数组中的查找
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int i=0;
        int j=array[0].length-1;
        while(i<array.length && j>=0){
            if(array[i][j]>target){
                j--;
            }else if(array[i][j]<target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
