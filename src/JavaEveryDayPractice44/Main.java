package JavaEveryDayPractice44;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/3/16 12:16
 */
class StringComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
public class Main {
    public static ArrayList<String> changeTelephone(List<String> list){
        ArrayList<String> stringList=new ArrayList<>();
        for(String s:list){
            StringBuilder sb=new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c >= 'A' && c <= 'Z') {
                        String str = String.valueOf(c);
                        if ("ABC".contains(str)) {
                            sb.append(2);
                        } else if ("DEF".contains(str)) {
                            sb.append(3);
                        } else if ("GHI".contains(str)) {
                            sb.append(4);
                        } else if ("JKL".contains(str)) {
                            sb.append(5);
                        } else if ("MNO".contains(str)) {
                            sb.append(6);
                        } else if ("PQRS".contains(str)) {
                            sb.append(7);
                        } else if ("TUV".contains(str)) {
                            sb.append(8);
                        } else {
                            sb.append(9);
                        }
                    } else if(c>='0' && c<='9'){
                        sb.append(c);
                    }
                }
                sb.insert(3,'-');
                if(!stringList.contains(sb.toString())){
                    stringList.add(sb.toString());
                }
            }
        return stringList;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            scanner.nextLine();
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                list.add(scanner.nextLine());
            }
            ArrayList<String> arrayList=changeTelephone(list);
            arrayList.sort(new StringComparator());
            for(String l:arrayList){
                System.out.println(l);
            }
            System.out.println();
        }
    }
}
