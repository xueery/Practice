package Practice1009;

import Practice0927.ExceptionDemo;

import java.io.IOException;

/**
 * @author:wangxue
 * @date:2019/10/9 8:05
 */
public class RuntimeDemo {
    public static void main(String[] args)throws Exception {
        Runtime rt=Runtime.getRuntime();
        System.out.println("处理器个数："+rt.availableProcessors()+"个");
        System.out.println("空闲内存大小："+rt.freeMemory()/1024/1024+"M");
        System.out.println("最大可用内存大小："+rt.maxMemory()/1024/1024+"M");
        //打开一个记事本进程
        Process process=rt.exec("notepad.exe");
        //程序休眠三秒
        Thread.sleep(3000);
        //关闭进程
        process.destroy();
    }
}
