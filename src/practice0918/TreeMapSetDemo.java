package practice0918;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/18 8:23
 */
public class TreeMapSetDemo {
    static class CardsComparator implements Comparator<Cards>{

        @Override
        public int compare(Cards o1, Cards o2) {
            int a=o1.value+o1.color.hashCode();
            int b=o2.value+o2.color.hashCode();
            return a-b;
        }
    }
    public static void main(String[] args) {
        CardsComparator compara=new CardsComparator();
        Map<Cards,String> map=new TreeMap<>(compara);
        Cards p=new Cards(2,"黑桃");
        Cards q=new Cards(2,"黑桃");
        map.put(p,"黑桃");
        System.out.println(map.getOrDefault(q,"-1"));
        Set<Cards> set=new TreeSet<>();
        set.add(q);
        System.out.println(set.contains(p));
        Set<ColorRuler> set2=new TreeSet<>();
        ColorRuler ruler1=new ColorRuler("blue");
        ColorRuler ruler2=new ColorRuler("blue");
        set2.add(ruler1);
        System.out.println(set2.contains(ruler2));
    }
}