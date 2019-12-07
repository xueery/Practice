package MyThread5;

/**
 * @author:wangxue
 * @date:2019/11/19 20:07
 */
public class Notify {
    private volatile static int COUNT=0;
    public synchronized static void produce(){
        COUNT+=3;
    }
    public synchronized static void consum(){
        COUNT-=1;
    }
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for(int j=0;j<10;j++){
                            synchronized (Notify.class){//生产者
                                while(COUNT+3>100){
                                    Notify.class.wait();
                                }
                                produce();
                                System.out.println(Thread.currentThread().getName()+"生产，库存总量"+COUNT);
                                Thread.sleep(500);
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {//消费者
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (Notify.class){
                                while (COUNT==0){
                                    Notify.class.wait();
                                }
                                consum();
                                System.out.println(Thread.currentThread().getName()+"消费,库存总量剩余"+COUNT);
                                Thread.sleep(500);
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}