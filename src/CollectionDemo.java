import java.util.*;
import java.util.ArrayList;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.add("I");
        list.add("like");
        list.add("java");
        Object[] array = list.toArray();
        //打印数组
        System.out.println(Arrays.toString(array));
        System.out.println();
        System.out.println();
        for (String s : list) {
            System.out.println(s);
        }
        list.remove("like");
        //foreach语法格式：
        //for(元素类型t 元素变量x：遍历对象）
        for(String s:list){
            System.out.println(s);
        }
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}

