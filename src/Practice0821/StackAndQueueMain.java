package Practice0821;

public class StackAndQueueMain {
    public static void main(String[] args) {
        MyQueueWithStack queue=new MyQueueWithStack();
        queue.push(9);
        queue.push(8);
        queue.push(7);
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.peek());

        MyStackWithQueue stack=new MyStackWithQueue();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        System.out.println(stack.empty());
        System.out.println(stack.top());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
    }
}
