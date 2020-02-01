package JavaEveryDayPractice17;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/11/24 9:19
 */

public class Main {
    public static void trainPullIn(int N,int[] arr) {
        Stack<Integer> stack=new Stack<>();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int N=scanner.nextInt();
            scanner.nextLine();
            String string=scanner.nextLine();
            String[] strings=string.split(" ");
            int[] arr=new int[strings.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.valueOf(strings[i]);
            }
            trainPullIn(N,arr);
        }
    }
}
