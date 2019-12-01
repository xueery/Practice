package MyThread1;

/**
 * @author:wangxue
 * @date:2019/11/6 20:09
 */
class MyThread extends Thread{
    MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class Sequence {
    public static void main(String[] args) {
        MyThread thread1=new MyThread("thread1");
        MyThread thread2=new MyThread("thread2");
        MyThread thread3=new MyThread("thread3");
        MyThread thread4=new MyThread("thread4");
        MyThread thread5=new MyThread("thread5");
        MyThread thread6=new MyThread("thread6");
        MyThread thread7=new MyThread("thread7");
        MyThread thread8=new MyThread("thread8");
        MyThread thread9=new MyThread("thread9");
        MyThread thread10=new MyThread("thread10");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}
