package JavaEveryDayPractice37;


import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/7 16:14
 */
public class Main {
    public static int[] calWord(String s){
        int[] arr=new int[26];
        for(char c:s.toCharArray()){
            if(c>='A' && c<='Z'){
                arr[c-65]++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            int[] arr=calWord(s);
            for(int i=0;i<arr.length;i++){
                System.out.print((char)(i+65)+":");
                System.out.println(arr[i]);
            }
        }
    }
}
