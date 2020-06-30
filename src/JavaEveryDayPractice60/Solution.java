package JavaEveryDayPractice60;

/**
 * @author:wangxue
 * @date:2020/6/23 9:53
 */
import java.util.ArrayList;
// 找和为sum的所有连续正数序列（最少两个数）
public class Solution {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=1;i<sum;i++){
            int num=i;
            for(int j=i+1;j<sum;j++){
                num+=j;
                if(num==sum){
                    ArrayList<Integer> l=new ArrayList<>();
                    for(int k=i;k<=j;k++){
                        l.add(k);
                    }
                    list.add(l);
                }else if(num<sum){
                    continue;
                }else{
                    break;
                }
            }
        }
        return list;
    }
}
