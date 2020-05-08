package Holiday17;

/**
 * @author:wangxue
 * @date:2020/2/13 19:19
 */
class Base{
    public Base(String s){
        System.out.println("B");
    }
}
public class Derived extends Base{
    public Derived(String s){
        super(s);
        System.out.println("D");
    }
}
