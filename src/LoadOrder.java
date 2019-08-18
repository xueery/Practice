class Parents{
    public Parents(){
        System.out.println("E");
    }
    public static int a=init1();
    public static int init1(){
        System.out.println("A");
        return 0;
    }
    {
        System.out.println("C");
    }
    public int b=init2();
    public int init2(){
        System.out.println("D");
        return 0;
    }
    static{
        System.out.println("B");
    }
}
public class LoadOrder extends Parents {
    public LoadOrder(){
        super();
        System.out.println(5);
    }
    public LoadOrder(int v){
        this();
        System.out.println(8);
    }
    public int c=initC();
    public int initC(){
        System.out.println(6);
        return 0;
    }
    {
        System.out.println(7);
    }
    public static int a=initA();
    static{
        System.out.println(2);
    }
    static{
        System.out.println(1);
    }
    public static int b=initB();
    public static int initA(){
        System.out.println(3);
        return 0;
    }
    public static int initB(){
        System.out.println(4);
        return 0;
    }
    public static void main(String[] args){
        new LoadOrder(100);
    }
}
