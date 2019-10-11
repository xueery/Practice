package practice0918;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2019/9/18 7:57
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<Cards, String> map = new HashMap<>();
        Cards p=new Cards(1,"黑桃");
        Cards q=new Cards(1,"黑桃");
        System.out.println(p.hashCode());
        System.out.println(q.hashCode());
        System.out.println(map.containsKey(q));
        Set<Cards> set=new HashSet<>();
        set.add(p);
        System.out.println(set.contains(q));
    }
}
