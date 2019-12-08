package MyThread6;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:wangxue
 * @date:2019/11/28 19:58
 */
public class ExectorsTest {
    //private static final ExecutorService EXE= Executors.newSingleThreadExecutor();//创建只有一个线程的线程池
    private static final ExecutorService EXE=Executors.newFixedThreadPool(5);//创建有5个线程的线程池
    //private static final ExecutorService EXE=Executors.newCachedThreadPool();//创建具有缓冲线程的线程池

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            final int j=i;
            EXE.submit(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        //只会进入5个线程，并且进入死循环
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        EXE.shutdown();
    }
}
