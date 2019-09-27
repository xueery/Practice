package Practice0902;

/**
 * @author:wangxue
 * @date:2019/9/2 19:47
 */
public class Person implements Comparable<Person> {
    String name;
    int age;
    int rank;


    @Override
    public String toString() {
        return String.format("Person+{%d}+{%d}",age,rank);
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}