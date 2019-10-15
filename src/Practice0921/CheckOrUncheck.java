package Practice0921;

import java.io.IOException;

/**
 * @author:wangxue
 * @date:2019/9/22 9:40
 */
public class CheckOrUncheck {
    //受查异常必须在方法列表中写出异常，
    // 并且具有传染性，即所有使用这个方法的方法也必须在方法中写出这个异常或者处理它
    public static void method1() throws IOException {
        throw new IOException();
    }
    //非受查异常
    public static void method2(){
        throw new ArrayIndexOutOfBoundsException();
    }
    public static void method3() throws IOException{
        method1();
    }
}
