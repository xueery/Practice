package JavaEveryDayPractice30;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/7 20:58
 */
public class Main {
    //错排问题，即每一个元素都不在自己应该在的下标处
    //第一步：考虑第n个元素，比如位置k，它有n-1中方法
    //第二步：对于位置k的元素，它可以有两种选择
    //1)他可以放在原来n元素的位置上，那么对于n-2个元素，有D(n-2)中放法
    //2)它不放在原来n元素的位置，那么对于剩余的n-1个元素，有D(n-1)中放法
    //错排算法公式：D(n)=(n-1)*(D(n-1)+D(n-2))
    public static double notHavePrice(int n){
        if(n==1){
            return 0;
        }else if(n==2){
            return 1;
        }else{
            return (n-1)*(notHavePrice(n-1)+notHavePrice(n-2));
        }
    }
    private static double factorial(int n){
        if(n==0){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            double ret=notHavePrice(n);
            double num=(ret/factorial(n))*100;
            System.out.print(String.format("%.2f",num));
            System.out.println("%");
        }
    }
}
