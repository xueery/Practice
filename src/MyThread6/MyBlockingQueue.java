package MyThread6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author:wangxue
 * @date:2019/11/28 19:26
 */
//阻塞式队列可以用于生产者消费者问题
//在多线程领域：所谓阻塞，在某些情况下会挂起线程（即阻塞），一旦条件满足，被挂起的线程又会自动被唤醒
public class MyBlockingQueue<E> {
    private Object[] elements;
    private int takeIndex;
    private int addIndex;
    private int size;
    public MyBlockingQueue(int capacity){
        elements=new Object[capacity];
    }
    public synchronized void offer(E element){
        try {
            while(size==elements.length){
                wait();
            }
            elements[addIndex]=element;
            addIndex=(addIndex+1)%elements.length;
            size++;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized E poll(){
        E element=null;
        try {
            while(size==0){
                wait();
            }
            element=(E)elements[takeIndex];
            takeIndex=(takeIndex+1)%elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return element;
    }
}
