package JianzhiOffer;

import java.util.ArrayList;

/**
 * @author:wangxue
 * @date:2021/2/23 13:38
 */
// 顺时针打印矩阵
public class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rowMin=0;
        int rowMax=matrix.length-1;
        int colMin=0;
        int colMax=matrix[0].length-1;
        ArrayList<Integer> list=new ArrayList<>();
        while (rowMin<=rowMax && colMin<=colMax){
            // 前行
            for(int i=colMin;i<=colMax;i++){
                list.add(matrix[rowMin][i]);
            }
            rowMin++;
            if(rowMin>rowMax)break;
            // 后列
            for(int i=rowMin;i<=rowMax;i++){
                list.add(matrix[i][colMax]);
            }
            colMax--;
            if(colMin>colMax)break;
            // 后行
            for(int i=colMax;i>=colMin;i--){
                list.add(matrix[rowMax][i]);
            }
            rowMax--;
            if(rowMin>rowMax)break;
            // 前列
            for(int i=rowMax;i>=rowMin;i--){
                list.add(matrix[i][colMin]);
            }
            colMin++;
            if(colMin>colMax)break;
        }
        return list;
    }
}
