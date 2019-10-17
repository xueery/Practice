package Practice0921;

/**
 * @author:wangxue
 * @date:2019/9/22 10:02
 */
public class ExceptionDemo2 {
    //try...catch()...finally的执行顺序：
    //如果抛出异常，不会立即回溯到上一个方法，而是仍然执行finally方法
    //其中下面这段代码中try中的return也的确执行了，但没有立即返回，而是执行finally方法有finally语句块返回
    //如果finally中没有返回语句，则由try语句中的return返回
    public static int method(){
        int i=0;
        try{
            System.out.println("try");
            i=i+3;
            return i++;
        }finally {
            System.out.println("finally");
            return i;
        }
    }
    public static void main(String[] args) {
        System.out.println(method());
    }
}
