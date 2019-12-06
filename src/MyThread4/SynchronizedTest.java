package MyThread4;

/**
 * @author:wangxue
 * @date:2019/11/17 20:47
 */
public class SynchronizedTest {
    public synchronized static void method1(){
        System.out.println(Thread.currentThread().getName());
    }
    public synchronized static void method2(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        MyObject myObject=new MyObject();
        //MyObject myObject2=new MyObject();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (myObject){
                    System.out.println(Thread.currentThread().getName());
                    while(true){}
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                myObject.method2();
            }
        }).start();
    }
}
class MyObject{
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName());
        while(true){}
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName());
        while(true){}
    }
}