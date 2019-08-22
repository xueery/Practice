import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Person{}
class animal{}
public class Test2{
    public static void main(String[] args) {
        ArrayList<Person> list=new ArrayList<>();
        List<animal> list1=new LinkedList<>();
        ArrayList<String> list2=new ArrayList<>();
        //instanceof运算符是用来在运行时指出对象是否是特定类的一个实例
        System.out.println(list instanceof List);
        System.out.println(list1 instanceof ArrayList);
        System.out.println(list2 instanceof ArrayList);
        // 获取当前对象所属类
        System.out.println(list.getClass());
        System.out.println(list1.getClass());
        System.out.println(list2.getClass());
    }
}

