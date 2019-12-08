package MyThread6;

/**
 * @author:wangxue
 * @date:2019/11/28 19:26
 */
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
