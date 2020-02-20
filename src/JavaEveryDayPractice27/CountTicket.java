package JavaEveryDayPractice27;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/12/5 16:52
 */
public class CountTicket {
    Map<String,Integer> map=new HashMap<>();
    //加入候选人名单
    public int addCandidate(String name){
        if(!map.containsKey(name)){
            map.put(name,0);
            return 1;
        }else{
            return 0;
        }
    }
    //投票
    public void vote(String name){
        if(map.containsKey(name)) {
            int count = map.get(name);
            map.put(name, ++count);
        }
    }
    //获取候选人票数
    public int getVoteResult(String name){
        if(map.containsKey(name)){
            return map.get(name);
        }else{
            return -1;
        }
    }
    public void clear(){
        map.clear();
    }

    public static void main(String[] args) {
        CountTicket countTicket=new CountTicket();
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                countTicket.addCandidate(s);
                list.add(s);
            }
            scanner.nextLine();
            int ticket = scanner.nextInt();
            scanner.nextLine();
            int invalid = 0;
            for (int i = 0; i < ticket; i++) {
                String name = scanner.next();
                countTicket.vote(name);
                int count = countTicket.getVoteResult(name);
                if (count == -1) {
                    invalid++;
                }
            }
            scanner.nextLine();
            Map<String, Integer> map = countTicket.map;
            for (String s : list) {
                int value = map.get(s);
                System.out.println(s + " : " + value);
            }
            countTicket.clear();
            System.out.println("Invalid : " + invalid);
        }
    }
}
