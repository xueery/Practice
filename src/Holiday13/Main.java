package Holiday13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2020/2/2 19:12
 */
public class Main {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        list.add(new ArrayList<>());
        for(int n:nums){
            int size=list.size();
            for(int i=0;i<size;i++){
                List<Integer> l=new ArrayList<>(list.get(i));
                l.add(n);
                list.add(l);
            }
        }
        return list;
    }
}
