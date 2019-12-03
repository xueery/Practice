package MyThread2;

/**
 * @author:wangxue
 * @date:2019/11/10 11:49
 */
public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        /*
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                     //调用sleep()/wait()/join()方法时，线程进入阻塞状态，此时也是可以中断，中断后抛出异常
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        //优势在于：可以中断join()/wait()/sleep()的阻塞线程
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        */
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    //boolean tmp=标志位
                    //标志位=false
                    //return tmp；
                    //作用：重置标志位为false，并且返回之前的标志位
                    boolean b=Thread.interrupted();
                    //获取当前标志位
                    //boolean b=Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });
        thread2.start();
        //Thread.sleep(5000);
        thread2.interrupt();//修改标志位=true，并没有中断线程
    }
}
