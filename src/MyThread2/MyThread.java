package MyThread2;

/**
 * @author:wangxue
 * @date:2019/11/10 9:10
 */
public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("明天要剁手了");
            }
        });
        thread.start();
        //不调用join时，创建线程会耗时较长，下边的main方法的代码会先执行
        //如果调用join，表示thread（线程的引用）会加入当前线程（javaMain主线程），等待thread执行完毕再执行后面代码
        thread.join();
        //下边代码常常会先执行，因为以上创建线程部分很耗时。
        System.out.println("今天还要上课");
    }
}
