package Practice0904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/9/5 17:26
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        map.put("wangxue",80);
        map.put("java",90);
        map.put("c++",100);
        map.put("wangxue",100);
        System.out.println(map.containsKey("c++"));
        System.out.println(map.getOrDefault("wangxue",0));
        System.out.println(map.get("java"));
        System.out.println(map.containsValue(10));
        for(Map.Entry<String,Integer> e:map.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
