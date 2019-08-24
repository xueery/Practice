import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        List<String> list1=new ArrayList<>(100);
        Set<String> set=new HashSet<>();
        list.add("123,666");
        set.add("good");
        set.add("better");
        set.add("good");
        set.add("best");
        List<String> list2=new ArrayList<>(set);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list2);
    }
}
