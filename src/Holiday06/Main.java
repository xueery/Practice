package Holiday06;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/1/23 13:24
 */
public class Main {
    public int[] sortedSquares(int[] A){
        for(int i=0;i<A.length;i++){
            if(A[i]<0){
                A[i]=-A[i];
            }
            A[i]*=A[i];
        }
        Arrays.sort(A);
        return A;
    }
    //917.仅仅反转字符串
    public String reverseOnlyLetters(String S) {
        char[] arr=S.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            while(i<j && !((arr[i]<='z' && arr[i]>='a')||(arr[i]<='Z' && arr[i]>='A'))){
                i++;
            }
            while(i<j && !((arr[j]<='z' && arr[j]>='a')||(arr[j]<='Z' && arr[j]>='A'))){
                j--;
            }
            char tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            i++;
            j--;
        }
        StringBuilder s=new StringBuilder();
        for(char c:arr){
            s.append(c);
        }
        return s.toString();
    }
}
