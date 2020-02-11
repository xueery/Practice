package JavaEveryDayPractice23;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/11/30 9:42
 */
public class Main {
    public static void checkIsSatisfy(String business,String customer){
        HashMap<Character,Integer> mapB=new HashMap<>();
        HashMap<Character,Integer> mapC=new HashMap<>();
        for(char c:business.toCharArray()){
            int count=mapB.getOrDefault(c,0);
            mapB.put(c,++count);
        }
        for(char c:customer.toCharArray()){
            int count=mapC.getOrDefault(c,0);
            mapC.put(c,++count);
        }
        int countMany=0;
        int countLitle=0;
        List<Character> list=new ArrayList<>();
        for(char c:mapC.keySet()){
            if(!mapB.containsKey(c)){
                countLitle+=mapC.get(c);
            }else{
                if(mapB.get(c)>=mapC.get(c)){
                    countMany+=(mapB.get(c)-mapC.get(c));
                }else{
                    countLitle+=(mapC.get(c)-mapB.get(c));
                }
            }
            list.add(c);
        }
        for(int i=0;i<list.size();i++){
            mapB.remove(list.get(i));
        }
        if(mapB.size()!=0) {
            for (char c : mapB.keySet()) {
                countMany += mapB.get(c);
            }
        }
        if(countLitle!=0){
            System.out.println("No "+countLitle);
        }else{
            System.out.println("YES "+countMany);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String business=scanner.nextLine();
        String customer=scanner.nextLine();
        checkIsSatisfy(business,customer);
    }
}
