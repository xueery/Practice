package Practice0906;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/6 20:09
 */
public class StringDemo {
    //思路：先将次数和网址分隔开
    //再将网址根据 .  分隔开，记录次数
    //最后用 . 拼接网址，记录在map中
    public static List<String> subdomainVisits(String[] webList) {
        Map<String, Integer> map = new HashMap<>();
        for (String e : webList) {
            String[] t = e.split(" ");
            int n = Integer.valueOf(t[0]);
            String[] u = t[1].split("\\.");
            for (int i = 0; i < u.length; i++) {
                String[] sub = Arrays.copyOfRange(u, i, u.length);
                String s = String.join(".", sub);
                int oldValue = map.getOrDefault(s, 0);
                map.put(s, n + oldValue);
            }
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String s=e.getKey();
            int c=e.getValue();
            result.add(c+" "+s);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] s={"900 google.mail.com","50 yohoo.com","1 intel.mail.com"};
        List<String> retString=subdomainVisits(s);
        System.out.println(retString);
    }
}
