package MyThread5;

import javax.security.sasl.SaslClient;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/19 22:48
 */
public class Foo {
    static volatile boolean firstFinish;
    static volatile boolean secondFinish;
    public Foo() {

    }

    public static void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstFinish=true;
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(firstFinish){
            printSecond.run();
            secondFinish=true;
            break;
        }
    }

    public static void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(secondFinish) {
            printThird.run();
            break;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("one");
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.print("two");
            }
        });
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("three");
            }
        });
        Scanner scanner=new Scanner(System.in);
        int[] arr=new int[3];
        for(int i=0;i<arr.length;i++){
            arr[i]=scanner.nextInt();
            scanner.nextLine();
        }
        first(thread1);
        second(thread2);
        third(thread3);
    }
}
