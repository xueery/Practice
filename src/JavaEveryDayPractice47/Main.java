package JavaEveryDayPractice47;

import java.util.HashMap;

/**
 * @author:wangxue
 * @date:2020/3/19 10:39
 */
public class Main {
    public static int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            int count = map.getOrDefault(i, 0);
            map.put(i, ++count);
        }
        for (int i : array) {
            if (map.get(i) > array.length) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array={1,2,3,2,2,2,5,4,2};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
}
