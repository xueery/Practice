package Practice1210;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/12 20:34
 */
//迷路的牛牛
public class Main1 {
    public static char lastDirection(String string,int n){
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:string.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        int L=map.getOrDefault('L',0);
        int R=map.getOrDefault('R',0);
        if(L==R){
            return 'N';
        }
        if(L>R){
            int count=L-R;
            if(count%4==0){
                return 'N';
            }else if(count%4==1){
                return 'W';
            }else if(count%4==2){
                return 'S';
            }else{
                return 'E';
            }
        }else{
            int count=R-L;
            if(count%4==0){
                return 'N';
            }else if(count%4==1){
                return 'E';
            }else if(count%4==2){
                return 'S';
            }else{
                return 'W';
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        String s=scanner.nextLine();
        System.out.println(lastDirection(s,n));
    }
}
