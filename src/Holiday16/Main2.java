package Holiday16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/2/12 11:01
 */
public class Main2 {
    public static int mostProfit(int deskN,int customerM,int[] deskPerson,List<List<Integer>> list){
        Arrays.sort(deskPerson);
        int sum=0;
        for(int i=0;i<deskPerson.length;i++){
            int most=0;
            int index=-1;
            for(int j=0;j<list.size();j++){
                if(list.get(j).get(0)<deskPerson[i]){
                    if(most<list.get(j).get(1)){
                        most=list.get(j).get(1);
                        index=j;
                    }
                }
            }
            sum+=most;
            list.remove(index);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int deskN=scanner.nextInt();
        int customerM=scanner.nextInt();
        scanner.nextLine();
        int[] deskPerson=new int[deskN];
        for(int i=0;i<deskPerson.length;i++){
            deskPerson[i]=scanner.nextInt();
        }
        scanner.nextLine();
        List<List<Integer>> list=new ArrayList<>(customerM);
        for(int i=0;i<list.size();i++){
            String s=scanner.nextLine();
            List<Integer> newList=new ArrayList<>();
            String[] strings=s.split(" ");
            newList.add(Integer.valueOf(strings[0]));
            newList.add(Integer.valueOf(strings[1]));
            list.add(newList);
        }
        System.out.println(mostProfit(deskN,customerM,deskPerson,list));
    }
}
