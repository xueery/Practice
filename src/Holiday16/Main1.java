package Holiday16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/2/12 10:33
 */
class StringComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        if(o1.length()>o2.length()){
            return 1;
        }else if(o1.length()<o2.length()){
            return -1;
        }else{
            for(int i=0;i<o1.length();i++){
                if(o1.charAt(i)>o2.charAt(i)){
                    return 1;
                }
                if(o1.charAt(i)<o2.charAt(i)){
                    return -1;
                }
            }
        }
        return 0;
    }
}
public class Main1 {
    public static String longestString(String s){
        int index=0;
        List<String> list=new ArrayList<>();
        while(index<s.length()){
            if(s.charAt(index)>='0' && s.charAt(index)<='9'){
                StringBuilder sb=new StringBuilder();
                for(int j=index;j<s.length();j++){
                    if(s.charAt(j)>='0' && s.charAt(j)<='9'){
                        sb.append(s.charAt(j));
                        if(j==s.length()-1){
                            index=j;
                            list.add(sb.toString());
                        }
                    }else{
                        index=j;
                        list.add(sb.toString());
                        break;
                    }
                }
            }
            index++;
        }
        list.sort(new StringComparator());
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println(longestString(scanner.nextLine()));
    }
}
