package Practice1210;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/13 19:17
 */
//获得最多的奖金
public class Main5 {
    public static long maxPrice(int[] arr){
        long maxprice=0;
        int i=0;
        int j=arr.length-1;
        long left=arr[i];
        long right=arr[j];
        while (i<j){
            if(left==right ){
                maxprice = left;
                if(i==j-1) {
                    return maxprice;
                }else{
                    i++;
                    left+=arr[i];
                    j--;
                    right+=arr[j];
                }
            }else if(left>right){
                j--;
                right+=arr[j];
            }else{
                i++;
                left+=arr[i];
            }
        }
        return maxprice;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            int[] arr=new int[n];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(maxPrice(arr));
        }
    }
}
