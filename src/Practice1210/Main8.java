package Practice1210;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/15 21:48
 */
public class Main8 {
    public static int[] stringSort(String[] strings){
        int[] array=new int[strings.length];
        for(int i=0;i<strings.length;i++){
            String s=strings[i].substring(strings[i].length()-6);
            array[i]=Integer.valueOf(s);
        }
        Arrays.sort(array);
        return array;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            String[] strings=new String[n];
            for(int i=0;i<n;i++){
                strings[i]=scanner.nextLine();
            }
            int[] array=stringSort(strings);
            for(int i:array){
                System.out.println(i);
            }
        }
    }
}
