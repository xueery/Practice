package Practice1002;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author:wangxue
 * @date:2019/10/5 17:39
 */
public class PriorityQueueDemo {
    static class BooksComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Books i=(Books) o1;
            Books j=(Books) o2;
            return i.price-j.price;
        }
    }
    //优先级队列
    public static void main(String[] args) {
        PriorityQueue<Books> queue=new PriorityQueue<>(new BooksComparator());
        Books book1 = new Books(12, "java");
        Books book2 = new Books(20, "操作系统");
        Books book3 = new Books(14, "c++");
        queue.add(book2);
        queue.add(book1);
        queue.add(book3);
        while(!queue.isEmpty()){
            Books b=queue.poll();
            System.out.println(b.price);
            System.out.println(b.name);

        }
        PriorityQueue<Integer> q=new PriorityQueue<>();
        q.add(6);
        q.add(1);
        q.add(9);
        q.add(5);
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }
    }
}
