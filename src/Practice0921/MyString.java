package Practice0921;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:wangxue
 * @date:2019/9/21 9:07
 */
public class MyString implements Comparable<MyString> {
    private final char[] value;
    //拷贝数组给this.value是为了保证引用不泄露
    //泄露将会导致属性的值可能被盖
    //即需要外部改变数组对MyString类中的数组并没有影响
    public MyString(char[] value) {
        this.value=Arrays.copyOf(value,value.length);
    }
    public MyString(char[] value, int offset, int count) {
        this.value=Arrays.copyOfRange(value,offset,offset+count);
    }
    //因为这个的构造对象形参也为MyStrin类型，则不需要担心的引用泄露
    public MyString(MyString s) {
        this.value=s.value;
    }

    public char charAt(int index) {
        return value[index];
    }
    public char[] charToArray() {
        char[] a=Arrays.copyOf(value,value.length);
        return a;
    }
    public MyString toUpper() {
        char[] a=Arrays.copyOf(value,value.length);
        for(int i=0;i<a.length;i++){
            if(a[i]>='a'&& a[i]<='z'){
                a[i]=(char)(a[i]-32);
            }
        }
        MyString s=new MyString(a);
        return s;
    }

    public MyString toLower() {
        char[] a=Arrays.copyOf(value,value.length);
        for(int i=0;i<a.length;i++){
            if(a[i]>='A'&& a[i]<='Z'){
                a[i]=(char)(a[i]+32);
            }
        }
        MyString s=new MyString(a);
        return s;
    }
    public boolean stringIgnoreCase(MyString s) {
        MyString m=this.toUpper();
        MyString n=s.toUpper();
        return m.equals(n);
    }
    public MyString subString(int begin, int end) {
        return new MyString(value,begin,end-begin);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        //判断相等四部曲
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(!(obj instanceof MyString)){
            return false;
        }
        return Arrays.equals(value,((MyString) obj).value);
    }

    @Override
    public String toString() {
        return new String(value);
    }

    @Override
    public int compareTo(MyString o) {
        if(o==null){
            return 1;
        }
        int length=Math.min(this.value.length,o.value.length);
        for(int i=0;i<length;i++){
            char m=value[i];
            char n=o.value[i];
            if(m>n){
                return 1;
            }else if(m<n){
                return -1;
            }
        }
        if(length<value.length){
            return 1;
        }
        if(length<o.value.length){
            return -1;
        }
        return 0;
    }
    //模拟常量池
    public static List<MyString> pool=new ArrayList<>();
    //自动入池
    public static MyString literal(MyString s){
        for(MyString e:pool){
            if(e.equals(s)){
                return  e;
            }
        }
        MyString ms=new MyString(s);
        pool.add(ms);
        return ms;
    }
    //手动入池
    public MyString intern(){
        for(MyString e:pool){
            if(e.equals(this)){
                return e;
            }
        }
        MyString ms=new MyString(this);
        pool.add(ms);
        return ms;
    }
    public static void main(String[] args) {
        char[] a = {'A', 'B', 'c'};
        MyString s=new MyString(a);
        MyString r=new MyString(s);
        MyString u=new MyString(a,0,2);
        MyString m=s.toUpper();
        System.out.println(u);
        System.out.println(s.equals(r));
        System.out.println(s.toUpper());
        System.out.println(s.stringIgnoreCase(m));
        System.out.println(s.subString(1,2));
        System.out.println(m.charAt(0));
        System.out.println(Arrays.toString(r.charToArray()));
        System.out.println(s.compareTo(m));
        System.out.println(s.hashCode());
        System.out.println(r.hashCode());
        System.out.println(m.hashCode());
        System.out.println(m.toLower());
        System.out.println(literal(s));
        System.out.println(literal(r));
        //检测是否指向同一个对象
        System.out.println(literal(s)==literal(r));
        MyString t=s.intern();
        System.out.println(literal(s)==t);
    }
}
