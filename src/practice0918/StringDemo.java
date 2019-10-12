package practice0918;

/**
 * @author:wangxue
 * @date:2019/9/18 15:54
 */
public class StringDemo {
    public static void main(String[] args) {
        //这种构造方式直接进入常量池
        String p="Hello";
        String q="Hello";
        //intern()是手动入池
        String o=new String("Hello").intern();
        System.out.println(p.equals(q));
        System.out.println(p.equals(o));
        //构建字符串
        StringBuilder sb=new StringBuilder();
        sb.append("Hello");
        sb.append("World");
        System.out.println(sb);
    }
}
