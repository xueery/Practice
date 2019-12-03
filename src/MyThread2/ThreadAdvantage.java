package MyThread2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/11/10 9:28
 */
public class ThreadAdvantage {
    public static List<String> randomList(){
        List<String> list=new LinkedList<>();
        char[] chars={'a','b','c','d','e','f'};
        for(int i=0;i<10000;i++){
            int random=new Random().nextInt(chars.length);
            char c=chars[random];
            list.add(String.valueOf(c));
        }
        return list;
    }
    public static void main(String[] args) throws InterruptedException {
        List<String> list=randomList();
        //创建十个线程，每个线程获取list中的10000个元素
        //两个都可以获取时间
        long start=System.currentTimeMillis();
        Thread[] threads=new Thread[10];
        //long start=new Date().getTime();
        for(int i=0;i<10;i++){
            final int k=i;
            threads[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        list.get(k*1000+j);
                    }
                    //两种方法都可以获取线程名称
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(threads[k].getName());
                }
            },"我的线程"+k);
            threads[i].start();
        }
        //判断当前有多少个线程在执行
        //==2表示当前线程只有Idea创建的线程和main线程
        //计算10个thread全部执行完的时间
        //第一种做法：线程让步
        /*
        while(Thread.activeCount()>2){
            //Main线程让步，让其他的线程先执行
            Thread.yield();
        }
        */
        //第二种做法：等待当前线程死亡，thread.join()
        for(Thread thread:threads){
            thread.join();
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
}
