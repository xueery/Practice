package JavaEveryDayPractice50;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/26 18:22
 */
public class Main {
    public static String deleteRepeat(String s){
        StringBuilder sb=new StringBuilder();
        int i=0;
        int index=0;
        while(i<s.length()-1){
            if(s.charAt(i)==s.charAt(i+1)){
                index++;
            }
            else{
                if(index==0){
                    sb.append(s.charAt(i));
                }else{
                    index=0;
                }
            }
            i++;
        }
        if(s.charAt(s.length()-2)!=s.charAt(s.length()-1)){
            sb.append(s.charAt(s.length()-1));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            String retStr=deleteRepeat(s);
            if(retStr.length()!=0){
                System.out.println(retStr);
            }else{
                System.out.println("no");
            }
        }
    }
}
