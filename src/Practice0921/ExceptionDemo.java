package Practice0921;

import java.io.IOException;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/9/22 9:27
 */
public class ExceptionDemo {
    static Random random=new Random();
    public static void a(){
        if(random.nextInt(6)==0)
            throw new RuntimeException("from a");
    }
    public static void b(){
        a();
        if(random.nextInt(6)==1)
            throw new RuntimeException("from b");
    }
    public static void c(){
        b();
        if(random.nextInt(6)==2)
            throw new RuntimeException("from c");
    }
    public static void d(){
        c();
        if(random.nextInt(6)==3)
            throw new RuntimeException("from d");
    }
    public static void e(){
        d();
        if(random.nextInt(6)==4)
            throw new RuntimeException("from e");
    }
    public static void main(String[] args) {
        try{
            e();
            System.out.println("good luck");
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            System.out.println("哈哈哈哈哈");
        }
        System.out.println("==============");
    }
}
