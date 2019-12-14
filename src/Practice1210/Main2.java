package Practice1210;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/12 20:48
 */
//表达式求值
public class Main2 {
    /**
     * 思路：先对输入的三个数进行排序
     * 遇到1则与1后面的数相加，因1*任何整数等于其本身
     * 遇到不等于1的数相乘
     * @param arr
     * @return
     */
    public static int findMaxValue(int[] arr){
        Arrays.sort(arr);
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                if(i!=(arr.length-1)) {
                    sum += arr[i] + arr[i + 1];
                    i++;
                }else{
                    sum+=arr[i];
                }
            }else{
                if(i==0){
                    sum=arr[i];
                }else {
                    sum *= arr[i];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int[] arr=new int[3];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(findMaxValue(arr));
        }
    }
}
