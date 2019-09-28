package Practice0902;

import java.util.Comparator;

/**
 * @author:wangxue
 * @date:2019/9/3 8:36
 */
public class PersonRankComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.rank-o2.rank;
    }
}
