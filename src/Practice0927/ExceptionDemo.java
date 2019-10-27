package Practice0927;

/**
 * @author:wangxue
 * @date:2019/9/27 19:52
 */
public class ExceptionDemo {
    class ParentException extends Exception{}
    class ChildException extends ParentException{}
    //覆写对异常的处理：可以异常相同 OR 子异常（包括没有异常）
    //调用拥有异常的方法：异常具有传染性，即调用时必须抛出同样的异常或者处理这个异常
    class Parent{
        void method() throws ParentException{

        }
    }
    class Child extends Parent{
        @Override
        void method() throws ChildException {
        }
    }
    public void get() throws ParentException {
        Parent e=new Parent();
        e.method();
    }
}