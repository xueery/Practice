package Practice1210;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/12/15 21:35
 */
public class Main7 {
    public static void countChar(String s){
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        for(Map.Entry<Character,Integer> m:map.entrySet()){
            System.out.print(m.getKey());
            System.out.print(m.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            countChar(s);
            System.out.println();
        }
    }
}
