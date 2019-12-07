package MyThread5;

/**
 * @author:wangxue
 * @date:2019/11/19 22:29
 */
public class PrintABC {
    public static void main(String[] args) throws InterruptedException {
        //循环输出ABC 10次
        for(int i=0;i<10;i++){
            Thread[] threads=new Thread[3];
            Thread thread1=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("A");
                }
            });
            Thread thread2=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("B");
                }
            });
            Thread thread3=new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.print("C");
                }
            });
            threads[0]=thread1;
            threads[1]=thread2;
            threads[2]=thread3;
            for(Thread thread:threads) {
                thread.start();
                thread.join();
            }
            System.out.println();
        }
    }
}
