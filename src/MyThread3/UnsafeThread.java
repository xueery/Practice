package MyThread3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2019/11/13 19:58
 */
public class UnsafeThread {
    public static int COUNT;
    public static void main(String[] args) throws InterruptedException {
        //创建对象在常量池
        String s1="abc";
        //先创建字符串a在常量池中，再在堆上创建字符串上s2,创建两个对象
        String s2=new String("a");
        //创建堆上的对象s3，因之前在常量池已经有字符串abc，即创建一个对象
        String s3=new String("abc");
        Thread[] threads=new Thread[20];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<20;i++) {
            final int k=i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        //COUNT++;
                        list.add(k*100000+j);
                    }
                }
            });
            threads[i].start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        /*
        for(Thread thread:threads){
            thread.join();
        }
        */
        System.out.println(list.size());
    }
}