package MyThread6;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;

/**
 * @author:wangxue
 * @date:2019/11/28 21:14
 */
public class MyTimer {
    //定时器

    /**
     *
     * @param task 执行的任务
     * @param delay 延迟多长时间
     * @param period 间隔多长时间再执行任务
     */
    public void schedule(Runnable task,long delay,long period){
        long next=System.currentTimeMillis()+delay;
        try {
            while(true){
                long current=System.currentTimeMillis();
                if(next>current){
                    Thread.sleep(next-current);
                }
                new Thread(task).start();
                if(period>0) {
                    next = next + period;
                }else{
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTimer().schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("该起床了");
            }
        },0,1000);
    }
}
