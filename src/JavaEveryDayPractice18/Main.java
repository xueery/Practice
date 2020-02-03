package JavaEveryDayPractice18;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/25 19:04
 */
public class Main {
    public static String findMuchGC(String string,int num){
        if(string.length()<=num){
            return string;
        }
        int max=0;
        int index=0;
        for(int i=0;i<string.length()-num+1;i++){
            if(max<countGC(string.substring(i,i+num))){
                max=countGC(string.substring(i,i+num));
                index=i;
            }
        }
        return string.substring(index,index+num);
    }
    private static int countGC(String string){
        int count=0;
        for(char c:string.toCharArray()){
            if(c=='G' || c=='C'){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String string = scanner.nextLine();
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println(findMuchGC(string, num));
        }
    }
}
