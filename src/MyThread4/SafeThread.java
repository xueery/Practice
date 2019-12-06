package MyThread4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2019/11/17 19:19
 */
public class SafeThread {
    public static int COUNT;
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<20;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<1000;j++){
                        increment();
                    }
                }
            }).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(COUNT);
    }
    public  static void increment(){
        synchronized (SafeThread.class){
            COUNT++;
        }
    }
}
