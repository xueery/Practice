package MyThread1;

/**
 * @author:wangxue
 * @date:2019/11/6 19:34
 */
class Mythread extends Thread{

    @Override
    public void run() {
        System.out.println("in thread");
        while(true){

        }
    }
}
class MyRunner implements Runnable{

    @Override
    public void run() {
        System.out.println("in runnable");
        while(true){

        }
    }
}
public class CreateThread {
    //JavaMain是java层面的主线程，和main方法中自行创建的线程同级
    public static void main(String[] args) {
        Mythread thread1=new Mythread();
        thread1.run();
        /*
        MyRunner runner=new MyRunner();
        Thread thread2=new Thread(runner);
        thread2.start();
        */
    }
}
