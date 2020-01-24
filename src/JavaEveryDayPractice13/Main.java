package JavaEveryDayPractice13;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/20 12:49
 */
public class Main {
    private static void drawSquare(int num,String s){
        char c=s.charAt(0);
        for(int i=0;i<Math.round(num/2.0);i++){
            for(int j=0;j<num;j++){
                if(i==0 || i==Math.round(num/2.0)-1){
                    System.out.print(c);
                }else{
                    if(j==0||j==num-1){
                        System.out.print(c);
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.split(" ");
        drawSquare(Integer.valueOf(strings[0]),strings[1]);
    }
}
