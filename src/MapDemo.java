import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        //返回键值对的数量
        System.out.println(map.size());
        //判断是否为空
        System.out.println(map.isEmpty());
        //根据指定的K查找对应的V
        System.out.println(map.get("good"));
        //根据指定的K查找对应的V，没有找到用默认值代替
        System.out.println(map.getOrDefault("good","better"));
        //判断是否包含key
        System.out.println(map.containsKey("good"));
        //判断是否包含value
        System.out.println(map.containsValue("better"));
        System.out.println("--------------");
        map.put("good","better");
        map.put("best","0");
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println(map.get("best"));
        System.out.println(map.getOrDefault("good","better"));
        System.out.println(map.containsKey("good"));
        System.out.println(map.containsValue("better"));
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
