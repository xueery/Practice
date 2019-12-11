package Practice1210;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/12/10 19:04
 */
public class Solution {
    //动态规划求解字符串分割问题
    public static boolean wordBreak(String s, Set<String> dict) {
        List<Integer> list=new ArrayList<>();
        //保存可以被分割的下标位置
        //辅助条件：0号下标处可以被分割
        list.add(0);
        //遍历字符串
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<list.size();j++){
                int n=list.get(j);
                if(dict.contains(s.substring(n,i))){
                    list.add(i);
                    break;
                }
            }
        }
        System.out.println(list);
        return list.contains(s.length());
    }
    //最小路径
    //给定一个m*n的网格，网格用非负数填充，找到一条从左上角到右下角的最短路径
    public int minPathSum(int[][] grid){
        int[][] minPath=new int[grid.length][grid[0].length];
        minPath[0][0]=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0){
                    if(j!=0) {
                        minPath[0][j] = minPath[0][j - 1] + grid[0][j];
                    }
                }else if(j==0){
                    minPath[i][0]=minPath[i-1][0]+grid[i][0];
                }else{
                    minPath[i][j]=Math.min(minPath[i-1][j],minPath[i][j-1])+grid[i][j];
                }
            }
        }
        return minPath[minPath.length-1][minPath[0].length-1];
    }
    public static void main(String[] args) {
        String s="leetcode";
        HashSet<String> set=new HashSet<>();
        set.add("leet");
        set.add("code");
        System.out.println(wordBreak(s,set));
    }
}
