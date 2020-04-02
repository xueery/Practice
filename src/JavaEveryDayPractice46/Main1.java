package JavaEveryDayPractice46;
import java.util.*;
/**
 * @author:wangxue
 * @date:2020/3/18 16:08
 */
public class Main1 {
    public static List<String> findCommonHead(List<String> list){
        List<String> l=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            String s=list.get(i);
            String str=s;
            int index=0;
            for(int j=0;j<list.size();j++){
                if(j!=i){
                    for(int k=index;k<s.length();k++){
                        if(k<list.get(j).length() && s.charAt(k)==list.get(j).charAt(k)){
                            index++;
                        }else{
                            break;
                        }
                    }
                }
            }
            System.out.println(str.substring(0,index+1));
            l.add(str.substring(0,index+1));
        }
        return l;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            List<String> list=new ArrayList<>();
            int n=scanner.nextInt();
            scanner.nextLine();
            for(int i=0;i<n;i++){
                list.add(scanner.nextLine());
            }
            List<String> l=findCommonHead(list);
            for(String s:l){
                System.out.println(s);
            }
        }
    }
}
