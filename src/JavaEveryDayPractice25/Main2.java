package JavaEveryDayPractice25;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/2 8:46
 */
//1.万万没想到之聪明的编辑(字节跳动2019编程题)
public class Main2 {
    public static String checkString(String string){
        List<Integer> list=new ArrayList<>();
        List<Character> listc=new ArrayList<>();
        char pre=string.charAt(0);
        int count=0;
        for(int i=0;i<string.length();i++){
            if(pre==string.charAt(i)){
                count++;
            }
            if(pre!=string.charAt(i)){
                list.add(count);
                listc.add(pre);
                count=1;
                pre=string.charAt(i);
            }
            if(i==string.length()-1){
                list.add(count);
                listc.add(pre);
            }
        }
        String ret="";
        for(int i=0;i<list.size();i++){
            if(list.get(i)<2){
                ret+=listc.get(i);
            } else{
                if(i>=1 && list.get(i-1)>=2){
                    ret+=listc.get(i);
                    list.set(i,1);
                }else{
                    ret+=listc.get(i);
                    ret+=listc.get(i);
                    list.set(i,2);
                }
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<n;i++) {
            String string = scanner.nextLine();
            System.out.println(checkString(string));
        }
    }
}
