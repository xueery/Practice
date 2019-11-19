package Practice1012;

/**
 * @author:wangxue
 * @date:2019/10/12 7:45
 */
class Person{
    //一个对象有三种状态：1）可用状态 2）可恢复状态 3）不可用状态
    //任何对象都可以覆写Object类的finalize()方法
    @Override
    public void finalize(){
        System.out.println("对象将作为垃圾被回收");
    }
}
public class GCDemo {
    public static void recyleWaste1(){
        //不通知强制垃圾回收的方法
        Person p1=new Person();
        p1=null;
        int i=1;
        while(i<10){
            System.out.println("方法1循环中");
            i++;
        }
    }
    public static void recyleWaste2(){
        //通知强制垃圾回收的方法
        Person p2=new Person();
        p2=null;
        int j=1;
        //强制系统进行垃圾回收
        System.gc();
        while(j<10) {
            System.out.println("方法2循环中");
            j++;
        }
    }
    public static void main(String[] args){
        recyleWaste1();
        System.out.println("==============");
        recyleWaste2();
    }
}
