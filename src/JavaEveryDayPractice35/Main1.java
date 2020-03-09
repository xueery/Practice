package JavaEveryDayPractice35;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/4 20:45
 */
public class Main1 {
    public final static double PI=Math.PI;
    public static double[] calGlobe(int[] arr){
        double[] nums=new double[2];
        double r=Math.sqrt(Math.pow(arr[0]-arr[3],2)+Math.pow(arr[1]-arr[4],2)+Math.pow(arr[2]-arr[5],2));
        double v=(4.0/3)*PI;
        v*=Math.pow(r,3);
        nums[0]=r;
        nums[1]=v;
        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int[] arr=new int[6];
            for(int i=0;i<arr.length;i++){
                arr[i]=scanner.nextInt();
            }
            scanner.nextLine();
            double[] nums=calGlobe(arr);
            System.out.println(String.format("%.3f %.3f",nums[0],nums[1]));
        }
    }
}
