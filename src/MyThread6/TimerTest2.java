package MyThread6;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author:wangxue
 * @date:2019/12/1 14:40
 */
class MyTimer2{
    private final static PriorityBlockingQueue<TimerTask> QUEUE=new PriorityBlockingQueue<>();

    public MyTimer2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        //调用可以等待任务的take方法
                        TimerTask task=QUEUE.take();
                        long current=System.currentTimeMillis();
                        if(task.getNext()>current){
                            //wait or sleep
                            //先把任务再次加入队列中
                            QUEUE.offer(task);
                            //队列休眠
                            synchronized (QUEUE) {
                                QUEUE.wait(task.getNext() - current);
                            }
                        }else {
                            //任务时间到了，可以执行
                            task.getTask().run();
                            //如果间隔时间大于0，则重新设置任务时间，再次加入队列
                            if(task.getPeriod()>0){
                                task.setNext(task.getNext()+task.getPeriod());
                                QUEUE.offer(task);
                            }else{
                                break;
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void shedule(Runnable task,long delay,long period){
        //将任务加到阻塞队列中
        QUEUE.add(new TimerTask(task,delay,period));
        synchronized (QUEUE){
            QUEUE.notify();
        }
    }
}
class TimerTask implements Comparable<TimerTask> {
    private Runnable task;//要执行的任务
    private long next;//要任务的时间执行
    private long period;//执行任务的间隔时间

    public TimerTask(Runnable task, long delay, long period) {
        this.task = task;
        this.next =System.currentTimeMillis()+ delay;
        this.period = period;
    }
    @Override
    public int compareTo(TimerTask o) {
        return Long.compare(this.next,o.next);
    }


    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}
public class TimerTest2 {
    public static void main(String[] args) {
        MyTimer2 timer2=new MyTimer2();
        timer2.shedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来了");
            }
        },0,1000);
        timer2.shedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我去了");
            }
        },0,1000);
    }
}
