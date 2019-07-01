public class Main {
    private static void testList(List list) {
        list.pushBack(1);
        list.pushBack(2);
        list.pushBack(3);
        list.pushFront(10);
        list.pushFront(20);
        list.pushFront(30);
        list.insert(3, 5);
        list.popFront();
        list.popBack();

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        testList(new ArrayList());
        testList(new LinkedList());
    }
}
