package JavaEveryDayPractice56;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/4/28 16:19
 */
class listComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
public class Main2 {
    public ArrayList<String> Permutation(String str) {
        StringBuilder sb=new StringBuilder(str);
        ArrayList<String> list=PermutationHelp(sb);
        return list;
    }
    public static ArrayList<String> PermutationHelp(StringBuilder str){
        ArrayList<String> result = new  ArrayList<>();
        if(str.length() == 1)result.add(str.toString());
        else{
            for(int i = 0; i < str.length(); i++){
                if(i== 0  || str.charAt(i) != str.charAt(0)){
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = PermutationHelp(new StringBuilder(str.substring(1)));
                    for(int j =0; j < newResult.size(); j++)
                        result.add(str.substring(0,1)+newResult.get(j));
                    //用完还是要放回去的
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            //需要在做一个排序操作
        }
        result.sort(new listComparator());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(PermutationHelp(new StringBuilder("abc")));
    }
}
