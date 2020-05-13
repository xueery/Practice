package JavaEveryDayPractice55;

/**
 * @author:wangxue
 * @date:2020/4/25 15:01
 */
import java.util.*;
public class Main1{
    public static int[] calNumber(int[] arr,int n){
        int[] ret=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int count=map.getOrDefault(arr[i],0);
            map.put(arr[i],++count);
        }
        int index=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getValue()%2!=0){
                ret[index++]=m.getKey();
            }
        }
        Arrays.sort(ret);

        return ret;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            int[] ret=calNumber(arr,n);
            System.out.println(ret[0]+" "+ret[1]);
        }
    }
}
