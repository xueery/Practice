package JavaEveryDayPractice46;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/18 18:05
 */
public class Main3 {
    public static int calMinMoney(List<Integer> list){
        int n=list.size()-1;
        int sum=0;
        while(n>0) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                if (min > list.get(i) + list.get(i + 1)) {
                    min = list.get(i) + list.get(i + 1);
                    index = i;
                }
            }
            sum+=min;
            list.set(index,min);
            for (int i = index + 1; i < list.size() - 1; i++) {
                list.set(i, list.get(i + 1));
            }
            list.remove(list.size() - 1);
            n--;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(scanner.nextInt());
            }
            scanner.nextLine();
            System.out.println(calMinMoney(list));
        }
    }
}
