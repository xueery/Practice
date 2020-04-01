package JavaEveryDayPractice46;
import java.util.*;
class StringComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
public class Main{
    public static List<String> searchBrotherWord(List<String> list,String word){
        list.sort(new StringComparator());
        List<String> l=new ArrayList<>();
        for(String s:list){
            if(isBrotherWord(s,word)){
                l.add(s);
            }
        }
        return l;
    }
    public static boolean isBrotherWord(String s,String str){
        if(s.equals(str)){
            return false;
        }
        if(s.length()!=str.length()){
            return false;
        }
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map1.getOrDefault(c,0);
            map1.put(c,++count);
        }
        for(char c:str.toCharArray()){
            int count=map2.getOrDefault(c,0);
            map2.put(c,++count);
        }
        for(char c:str.toCharArray()){
            int num=map2.get(c);
            int ret=map1.getOrDefault(c,0);
            if(num!=ret){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            List<String> list=new ArrayList<>();
            int num=scanner.nextInt();
            for(int i=0;i<num;i++){
                list.add(scanner.next());
            }
            String word=scanner.next();
            int k=scanner.nextInt();
            scanner.nextLine();
            List<String> l=searchBrotherWord(list,word);
            System.out.println(l.size());
            if(!(l.size()==0 || k>l.size())){
                System.out.println(l.get(k-1));
            }
        }
    }
}