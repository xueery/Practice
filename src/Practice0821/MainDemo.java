package Practice0821;

public class MainDemo {
    public static void main(String[] args) {
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int ret=stack.pop();
        System.out.println(ret);
        int size=stack.size();
        System.out.println(size);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.search(7));

        MyQueue queue=new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.last());
        System.out.println(queue.front());
        System.out.println(queue.pop());
        System.out.println(queue.size());
        System.out.println(queue.empty());
    }
}
