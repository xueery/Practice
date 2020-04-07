package JavaEveryDayPractice48;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/3/20 11:36
 */
class People{
    int weight;
    int height;

    public People(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
//动态规划dp
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            People[] peoples=new People[n];
            for (int i = 0; i < n; i++) {
                int index=scanner.nextInt();
                peoples[index-1]=new People(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(peoples, new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    int result=Integer.compare(o1.height,o2.height);
                    if(result!=0){
                        return result;
                    }
                    return Integer.compare(o1.weight,o2.weight);
                }
            });
            int[] dp = new int[n];
            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if(peoples[i].weight>peoples[j].weight ||
                            (peoples[i].weight==peoples[j].weight && peoples[i].height==peoples[j].height)){
                        dp[i]=Math.max(dp[i],dp[j]+1);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);
        }
    }
}
