class Base{
    static {
        System.out.println("静态初始化");
    }
    {
        System.out.println("代码块构造");
    }
    Base(){
        System.out.println("初始化");
    }
}
class Drived extends Base{
    static{
        System.out.println("静态初始化");
    }
    {
        System.out.println("代码块构造");
    }
    Drived() {
        System.out.println("构造方法初始化");
    }
}
public class Interview {
    public static void main(String[] args){
        new Drived();
    }
}
