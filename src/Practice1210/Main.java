package Practice1210;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/10 22:42
 */
class HardAndReward implements Comparable<HardAndReward>{
    private int hard;
    private int reward;

    public HardAndReward(int hard, int reward) {
        this.hard = hard;
        this.reward = reward;
    }

    public int getHard() {
        return hard;
    }

    public void setHard(int hard) {
        this.hard = hard;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @Override
    public int compareTo(HardAndReward o) {
        return getHard()-o.getHard();
    }
}
public class Main {
    //暴力求解，牛客网不通过
    public static List<Integer> calMaxReward(List<HardAndReward> list,List<Integer> ablity){
        List<Integer> ret=new ArrayList<>();
        for(int i:ablity){
            int max=0;
            for(HardAndReward har:list){
                if(har.getHard()<=i){
                    if(max<har.getReward()){
                        max=har.getReward();
                    }
                }
            }
            ret.add(max);
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int work=scanner.nextInt();
        int person=scanner.nextInt();
        scanner.nextLine();
        List<HardAndReward> list=new ArrayList<>();
        for(int i=0;i<work;i++){
            HardAndReward har=new HardAndReward(scanner.nextInt(),scanner.nextInt());
            list.add(har);
            scanner.nextLine();
        }
        List<Integer> ability=new ArrayList<>();
        for(int i=0;i<person;i++){
            ability.add(scanner.nextInt());
        }
        scanner.nextLine();
        List<Integer> ret=calMaxReward(list,ability);
        for(int r:ret){
            System.out.println(r);
        }
    }
}
