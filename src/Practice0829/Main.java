package Practice0829;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author:wangxue
 * @date:2020/4/15 15:36
 */
public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        Set<Integer> set=new HashSet<>();
        while(true){
            if(set.size()<100){
                set.add(random.nextInt(1000));
            }else{
                break;
            }
        }
    }
}
