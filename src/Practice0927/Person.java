package Practice0927;

/**
 * @author:wangxue
 * @date:2019/9/27 18:27
 */
public class Person {
    //无参构造方法调用有参构造方法
    final String name;
    Person(){
        this("张三");
    }
    Person(String name){
        this.name=name;
    }
    void getName(){
        System.out.println(this.name);
    }
    public static void main(String[] args) {
        Person p=new Person();
        p.getName();
    }
}