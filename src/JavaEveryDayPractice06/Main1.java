package JavaEveryDayPractice06;

import com.sun.imageio.plugins.common.I18N;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/11 13:13
 */
public class Main1 {
    private static int checkHalfLength(int[] arr,int size){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<size;i++){
            int count=map.getOrDefault(arr[i],0);
            map.put(arr[i],++count);
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue()>=size/2){
                return e.getKey();
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        int[] arr=new int[100];
        String[] strings=str.split(" ");
        for(int i=0;i<strings.length;i++){
            arr[i]=Integer.valueOf(strings[i]);
        }
        System.out.println(checkHalfLength(arr,strings.length));
    }
}
