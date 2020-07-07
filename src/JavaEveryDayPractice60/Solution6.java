package JavaEveryDayPractice60;

/**
 * @author:wangxue
 * @date:2020/6/30 9:26
 */
public class Solution6 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null && str==null) return true;
        if(matrix==null || str==null) return false;
        // 表示标志位
        boolean[] flags=new boolean[matrix.length];
        // 遍历横纵坐标，找到符合要求的
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(judge(matrix,i,j,rows,cols,flags,str,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flags, char[] str, int k) {
        // 表示当前的位置
        int index=i*cols+j;
        // 如果坐标位置越界 || 此坐标处的字符不等于字符串此处的字符 || 这个坐标已经走过  返回false
        if(i<0 || i>=rows || j<0 || j>cols || matrix[index]!=str[k] || flags[index]){
            return false;
        }
        // 走到此处代表以上情况都不符合，及满足要求，则下标置为true，表示走过
        flags[index]=true;
        // 如果 k 走到最后一个则代表成功
        if(k==str.length-1) return true;
        // 判断 上、下、左、右 中的一个是否满足，如果满足则返回true
        if(judge(matrix,i+1,j,rows,cols,flags,str,k+1)
                || judge(matrix,i-1,j,rows,cols,flags,str,k+1)
                || judge(matrix,i,j+1,rows,cols,flags,str,k+1)
                || judge(matrix,i,j-1,rows,cols,flags,str,k+1)){
            return true;
        }
        // 走到此处表示上、下、左、右 都不满足要求，则将坐标置为false，表示没走过
        flags[index]=false;
        return false;
    }
}
