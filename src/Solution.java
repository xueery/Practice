import java.util.ArrayList;
import java.util.List;

public class Solution {
    //杨辉三角
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> list=new ArrayList<>(numRows);
        //list是一种引用，List类型的接口引用（java语法）
        //list逻辑上是一种线性表
        //线性表的元素类型是List<Integer>
        //          (java语法）List类型的接口引用
        //                     元素类型是Integer类类型的引用
        //                     Integer是int的包装类
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<numRows;i++){
            list.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int num=list.get(i-1).get(j)+list.get(i-1).get(j+1);
                list.get(i).add(num);
            }
            if(i!=0) {
                list.get(i).add(1);
            }
        }
        return list;
    }
    public List<List<Integer>> generatetwo(int numRows){
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            list.add(new ArrayList<>(i+1));
        }
        list.get(0).add(1);
        list.get(1).add(1);
        list.get(1).add(1);
        for(int i=2;i<numRows;i++){
            list.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int num=list.get(i-1).get(j)+list.get(i-1).get(j+1);
                list.get(i).add(num);
            }
            list.get(i).add(1);
        }
        return list;
    }
    public static void printPascalsTriangle(Solution s,int numRows){
        System.out.println(s.generate(numRows));
        System.out.println(s.generatetwo(numRows));
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        printPascalsTriangle(s,7);
    }
}