package JavaEveryDayPractice29;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/6 22:43
 */
public class Main {
    public static boolean checkDefensiveType(int n){
        int powNum=(int)Math.pow(n,2);
        String s=String.valueOf(n);
        String powS=String.valueOf(powNum);
        if(powS.endsWith(s)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();
            scanner.nextLine();
            if(checkDefensiveType(num)){
                System.out.println("YES!");
            }else{
                System.out.println("NO!");
            }
        }
    }
}
