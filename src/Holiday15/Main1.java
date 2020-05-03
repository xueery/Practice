package Holiday15;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/2/15 11:53
 */
public class Main1 {
    public static int calSum(List<Integer> list, int n){
        int count=0;
        for(int i=0;i<list.size();i++){
            for(int j=i;j<list.size();j++){
                if(list.get(i)+list.get(j)==n){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        int n=scanner.nextInt();
        System.out.println(calSum(list,n));
    }
}
