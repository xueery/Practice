package JavaEveryDayPractice05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/9 23:24
 */
public class Main {
    public static int countDifferentWays(int v,List<Integer> list){
        int count=0;
        for(int i=0;i<v;i++){
            int sum=0;
            for(int j=i;j<v;j++){
                sum=sum+list.get(j);
                if(sum==40){
                   count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int v=scanner.nextInt();
        scanner.nextLine();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
            scanner.nextLine();
        }
        System.out.println(list);
        System.out.println(countDifferentWays(v,list));
    }
}
