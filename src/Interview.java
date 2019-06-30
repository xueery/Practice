class Base{
    static int Field=FieldStatic();
    static int FieldStatic(){
        System.out.println("静态变量初始化1");
        return 0;
    }
    static {
        System.out.println("静态代码块初始化1");
    }
    int field=field1();
    int field1(){
        System.out.println("变量初始化1");
        return 0;
    }
    {
        System.out.println("代码块构造1");
    }
    Base(){
        System.out.println("构造方法初始化1");
    }
}
class Drived extends Base{
    static int Field=FieldStatic();
    static int FieldStatic(){
        System.out.println("静态变量初始化2");
        return 0;
    }
    static{
        System.out.println("静态代码块初始化2");
    }
    int field=field1();
    int field1(){
        System.out.println("变量初始化2");
        return 0;
    }
    {
        System.out.println("代码块构造2");
    }
    Drived() {
        System.out.println("构造方法初始化2");
    }
}
public class Interview {
    public static void main(String[] args){
        new Drived();
    }
}
