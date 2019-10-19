package Practice0921;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/23 8:42
 */
public class ExceptionDemo3 {
    //无关于java语法、结构等，只想测试try、catch、finally的具体执行顺序
    //try语句中抛出的异常，如果在catch中被捕获，则会一步步向下执行，包括整个try语句块之后的语句，
    // 但如果catch语句中还有throw语句，则执行完finally语句不会再执行try整个语句块之后的语句，直接抛出异常
    // 如果没有被catch捕获，则执行完finally之后不再执行后面的语句
    public static void method(){
        int[] a=new int[2];
        try{
            int x=a[2];
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println("catch");
            throw new NullPointerException();
        }finally{
            System.out.println("finally");
        }
        System.out.println("==========");
    }
    public static void main(String[] args) {
        method();
    }
}
