package JavaEveryDayPractice32;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/3/1 20:19
 */
public class Main1 {
    public static Map<String,Integer> errorRecord(Map<String,Integer> map,String s){
        int count=map.getOrDefault(s,0);
        map.put(s,++count);
        return map;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int count=0;
        Map<String,Integer> map=new HashMap<>();
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            s=s.substring(s.lastIndexOf("\\")+1,s.length());
            map = errorRecord(map, s);
        }
        for(Map.Entry<String,Integer> m:map.entrySet()){
            count++;
            if(count>map.keySet().size()-8){
                String s=m.getKey();
                if(s.length()>16){
                    s=s.substring(s.length()-16,s.length());
                }
                System.out.println(s+" "+m.getValue());
            }
        }
    }
}
