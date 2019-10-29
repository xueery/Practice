package Practice1001;

import Practice0902.Person;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/1 17:42
 */
public class ListDemo {
    //queue是一个接口，需要类去实现它，栈是一个类，可以直接实例化对象
    public List buildArrayList(){
        List<Integer> list=new ArrayList<>();
        List<Integer> addList=new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1,2);
        list.add(2,3);
        addList.add(5);
        addList.add(6);
        addList.add(7);
        addList.add(8);
        list.addAll(5,addList);
        return list;
    }
    public Deque<Character> buildLinkedList(){
        //双端队列
        Deque<Character> list=new LinkedList<>();
        list.addFirst('H');
        list.addLast('N');
        list.addLast('A');
        list.pollLast();
        list.addFirst('C');
        list.pollLast();
        list.addLast('I');
        list.addLast('N');
        list.addLast('A');
        return list;
    }
    public static void main(String[] args) {
        ListDemo list=new ListDemo();
        System.out.println(list.buildArrayList());
        System.out.println(list.buildLinkedList());
    }
}
