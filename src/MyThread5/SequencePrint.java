package MyThread5;

import MyThread1.Sequence;

/**
 * @author:wangxue
 * @date:2019/11/22 18:53
 */
public class SequencePrint {
    private static String INDEX="A";
    public static void main(String[] args) {
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for(int i=0;i<10;i++){
                        synchronized (SequencePrint.class){
                            while(!INDEX.equals("A")){
                                SequencePrint.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX="B";
                            Sequence.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
