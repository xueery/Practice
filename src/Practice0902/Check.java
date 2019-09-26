package Practice0902;

import java.util.List;

/**
 * @author:wangxue
 * @date:2019/9/3 21:15
 */
public class Check<E>{
    private E[] array;
    private int size;
    public Check(){
        array=(E[])new Object[100];
        size=0;
    }
    public static void disprint(List<?> list){
        System.out.println("null");
    }
    public static <E> void swap(E[] array,int i,int j){
        E t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    public static void main(String[] args) {
        List<Object> list1=null;
        List<Integer> list2=null;
        disprint(list1);
        disprint(list2);
        String[] string=new String[10];
        swap(string,0,3);
    }
}
