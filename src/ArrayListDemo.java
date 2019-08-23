import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
        public static void main(String[] args) {
            List<String> list=new ArrayList<>();
            list.add("Hello");
            list.add("world");
            list.add(1,"世界");
            list.add(1,"你好");
            list.remove(0);
            System.out.println(list.get(1));
            System.out.println(list.contains("world"));
            System.out.println(list.size());
            System.out.println(list.isEmpty());
            System.out.println(list);
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
            System.out.println("==============");
            ArrayList<Integer> listTwo=new ArrayList<>();
            listTwo.add(1);
            listTwo.add(1,2);
            listTwo.add(4);
            list.remove(2);
            System.out.println(listTwo.isEmpty());
            System.out.println(listTwo.size());
            System.out.println(listTwo);
            System.out.println(listTwo.contains(6));
            System.out.println(listTwo.get(1));
        }
    }
