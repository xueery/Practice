package Practice0904;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2019/9/5 17:16
 */
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("Hello");
        set.add("Hello");
        set.add("java");
        set.add("c++");
        System.out.println(set);
        System.out.println(set.contains("Hello"));
        for(String e:set){
            System.out.println(e);
        }
        set.clear();
        System.out.println(set.isEmpty());
        System.out.println(set);
    }
}
