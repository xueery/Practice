package Practice0902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/9/2 20:18
 */
public class SortInJava {
    public static void main(String[] args) {
        Person[] people=new Person[10];
        Random random=new Random(20190903);
        for(int i=0;i<people.length;i++){
            people[i]=new Person();
            people[i].age=random.nextInt(30);
            people[i].rank=random.nextInt(50);
        }
        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
        Arrays.sort(people,new PersonRankComparator());
        System.out.println(Arrays.toString(people));
        List<Person> person=new ArrayList<>();
        person.sort(new PersonRankComparator());
        System.out.println(person);
    }
}
