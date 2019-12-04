package MyThread3;

/**
 * @author:wangxue
 * @date:2019/11/13 19:36
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while(!Thread.interrupted()){
                    System.out.println("运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
