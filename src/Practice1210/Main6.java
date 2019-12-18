package Practice1210;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/13 19:32
 */
//ipv4地址白名单
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            HashSet<String> set = new HashSet<>();
            while(true) {
                String s = scanner.nextLine();
                if(s.equals("end")){
                    break;
                }else {
                    String[] strings = s.split(":");
                    if (strings[0].charAt(0) == 'i') {
                        set.add(strings[1]);
                        System.out.println("ok");
                    } else if (strings[0].charAt(0) == 'd') {
                        set.remove(strings[1]);
                        System.out.println("ok");
                    } else {
                        if (set.contains(strings[1])) {
                            System.out.println("true");
                        } else {
                            System.out.println("false");
                        }
                    }
                }
            }
        }
    }
}
