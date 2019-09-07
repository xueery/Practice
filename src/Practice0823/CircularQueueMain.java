package Practice0823;

public class CircularQueueMain {
    public static void main(String[] args) {
        CircularQueue queue=new CircularQueue(5);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(5));
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(6));
        System.out.println(queue.front());
        System.out.println(queue.rear());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.printQueue();
    }
}
