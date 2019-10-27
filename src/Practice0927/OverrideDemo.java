package Practice0927;

/**
 * @author:wangxue
 * @date:2019/9/27 18:55
 */
//关于方法的覆写，四个要求：1）方法名称相同 2）形参列表相同
// 3）返回值相同或是它的子类型 4）访问限定符，不能比父类的严格 5)异常类型相同 OR 子类型
public class OverrideDemo {
    Animal get(){
        return null;
    };
}

class Animal{}

class Bird extends Animal{}

class OverrideExtend extends OverrideDemo{
    @Override
    Bird get() {
        return null;
    }
}
