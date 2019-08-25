import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.addLast("java");
        list.addFirst("C");
        list.addLast("数据结构");
        list.addFirst("操作系统");
        list.add("C++");
        list.add("算法设计");
        list.add("编程语言");
        System.out.println(list.size());
        System.out.println(list);
        //取并且删
        //头删
        System.out.println(list.pop());
        System.out.println(list);
        list.push("离散数学");
        System.out.println(list);
        //取并且删
        //头删
        System.out.println(list.poll());
        System.out.println(list.pollFirst());
        System.out.println(list.pollLast());
        //取而不删
        System.out.println(list.peekFirst());
        //检索第一个
        System.out.println(list.peek());
        System.out.println(list.peekLast());
        System.out.println(list.size());
        System.out.println(list);
    }
}
