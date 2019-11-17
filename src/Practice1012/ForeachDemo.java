package Practice1012;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author:wangxue
 * @date:2019/10/12 8:31
 */
public class ForeachDemo {
    public static void main(String[] args) {
        //foreach循环并不能修改数组中元素的值，它只是将临时变量S指向一个新的字符串
        String[] strings={"aaa","bbb","ccc"};
        for(String s:strings){
            s="ddd";
        }
        System.out.println("foreach修改后的数组："+strings[0]+","+strings[1]+","+strings[2]);
        for(int i=0;i<strings.length;i++){
            strings[i]="ddd";
        }
        System.out.println("普通for循环修改后的数组："+strings[0]+","+strings[1]+","+strings[2]);
        //JDK 8 的forEach遍历集合
        ArrayList<String> list=new ArrayList<>();
        list.add("888");
        list.add("999");
        list.add("666");
        //该方法所需要的参数是一个函数式接口（Lambda表达式）
        list.forEach(obj-> System.out.println("迭代遍历集合元素："+obj));
        //迭代器对象的遍历方法
        Iterator it= list.iterator();
        it.forEachRemaining(obj-> System.out.println("迭代器集合遍历元素"+obj));
    }
}
