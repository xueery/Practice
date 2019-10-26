package Practice0927;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2019/9/27 19:11
 */
enum Gender{
    FEMALE,MALE
}
enum Days{
    MONDAY,THESDAY,WEDNESDAY
}
public class EnumDemo {
    public static void main(String[] args) {
        Gender gender=Gender.FEMALE;
        System.out.println(gender);
        System.out.println(Arrays.toString(Gender.values()));
        Gender g=Gender.valueOf("MALE");
        System.out.println(g);
        Days day=Days.MONDAY;
        System.out.println(day);
        System.out.println(Arrays.toString(Days.values()));
    }
}