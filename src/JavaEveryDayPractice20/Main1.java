package JavaEveryDayPractice20;

import java.io.CharArrayReader;
import java.util.*;

/**
 * @author:wangxue
 * @date:2019/11/27 12:19
 */
class HighToLowComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.score-o2.score;
    }
}
class LowToHighComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o2.score-o1.score;
    }
}
class Person{
    String name;
    int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int seq = scanner.nextInt();
            scanner.nextLine();
            List<Person> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String string = scanner.nextLine();
                String[] strings = string.split(" ");
                Person person = new Person();
                person.setName(strings[0]);
                person.setScore(Integer.valueOf(strings[1]));
                list.add(person);
            }
            if (seq == 1) {
                list.sort(new HighToLowComparator());
            } else {
                list.sort(new LowToHighComparator());
            }
            for (Person p : list) {
                System.out.println(p.getName() + " " + p.getScore());
            }
        }
    }
}
