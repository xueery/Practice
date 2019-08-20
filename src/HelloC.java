class HelloA{
    public HelloA(){
        System.out.println("父类的无参构造方法");
    }
    static{
        System.out.println("父类的静态代码块");
    }
    {
        System.out.println("父类的代码块");
    }
    public static int b=buildB();
    public static int buildB(){
        System.out.println("父类的静态定义初始化");
        return 0;
    }
}
class HelloB extends HelloA{
    public HelloB(){
        System.out.println("子类的无参构造方法");
    }
    public HelloB(int v){
        this();
        System.out.println("子类的有参构造方法");
    }
    {
        System.out.println("子类的代码块");
    }
    static{
        System.out.println("子类的静态代码块");
    }
    public int a=bulidA();
    public int bulidA(){
        System.out.println("子类的定义初始化");
        return 0;
    }
}
public class HelloC {
    public static void main(String[] args) {
        System.out.println("Start--");
        new HelloB(100);
        System.out.println("end--");
    }
}
