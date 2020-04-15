package JavaEveryDayPractice54;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2020/4/13 20:47
 */
public class Main3 {

    public static List<List<Integer>> subSetAll(int[] arr,int n){
        if(arr==null || arr.length==0){
            return new ArrayList<>();
        }
        return subSetAllInternal(arr,n);
    }

    public static List<List<Integer>> subSetAllInternal(int[] arr,int n){
        List<List<Integer>> outter=new ArrayList<>();
        List<Integer> inner;
        if(n==1){
            inner=new ArrayList<>();
            inner.add(arr[0]);
            outter.add(inner);
            return outter;
        }

        List<List<Integer>> temp=subSetAllInternal(arr,n-1);
        for(int i=0;i<temp.size();i++){
            inner=new ArrayList<>();
            inner.addAll(temp.get(i));
            inner.add(arr[n-1]);
            outter.add(inner);
        }

        inner=new ArrayList<>();
        inner.add(arr[n-1]);
        outter.add(inner);//arr[n-1]作为一个单独的子集加入
        outter.addAll(temp);//之前的集合也应该加入集合中

        return outter;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(subSetAll(arr,4));
    }
}
