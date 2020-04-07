package JavaEveryDayPractice49;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/3/20 19:03
 */
public class Main {
    public int findMaxGap(int[] A, int n) {
        // write code here
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            int maxLeft=searchMax(A,0,i);
            int maxRight=searchMax(A,i+1,n-1);
            max=Math.max(max,Math.abs(maxLeft-maxRight));
        }
        return max;
    }

    private int searchMax(int[] arr, int left, int right) {
        int max=Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }

    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = m - 1;
        int[] ret = new int[n * m];
        int index = 0;
        while (minRow <= maxRow && minCol <= maxCol) {
            for (int i = minCol; i <= maxCol; i++) {
                ret[index++] = mat[minRow][i];
            }
            minRow++;
            if(minRow>maxRow){
                break;
            }
            for (int i = minRow; i <= maxRow; i++) {
                ret[index++] = mat[i][maxCol];
            }
            maxCol--;
            if(minCol>maxCol){
                break;
            }
            for (int i = maxCol; i >= minCol; i--) {
                ret[index++] = mat[maxRow][i];
            }
            maxRow--;
            if(minRow>maxRow){
                break;
            }
            for (int i = maxRow; i >= minRow; i--) {
                ret[index++] = mat[i][minCol];
            }
            minCol++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] array={{1,2,3},{6,7,8},{11,12,13}};
        System.out.println(Arrays.toString(clockwisePrint(array,3,3)));
    }
}
