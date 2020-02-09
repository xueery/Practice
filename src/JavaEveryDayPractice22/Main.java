package JavaEveryDayPractice22;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/28 22:37
 */
public class Main {
    public static String breakPassWord(String string){
        String ret="";
        HashMap<Character,Character> map=new HashMap<>();
        map.put('A','V');map.put('B','W');map.put('C','X');map.put('D','Y');map.put('E','Z');
        map.put('F','A');map.put('G','B');map.put('H','C');map.put('I','D');
        map.put('J','E');map.put('K','F');map.put('L','G');map.put('M','H');
        map.put('N','I');map.put('O','J');map.put('P','K');map.put('Q','L');
        map.put('R','M');map.put('S','N');map.put('T','O');map.put('U','P');
        map.put('V','Q');map.put('W','R');map.put('X','S');map.put('Y','T');map.put('Z','U');
        for(char c:string.toCharArray()){
            if(map.containsKey(c)){
                ret=ret+map.get(c);
            }else{
                ret=ret+" ";
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String string=scanner.nextLine();
            System.out.println(breakPassWord(string));
        }
    }
}
