package Practice0821;

public class MinStackMain {
    public static void main(String[] args) {
        MinStack minstack=new MinStack();
        minstack.push(3);
        minstack.push(6);
        minstack.push(7);
        System.out.println(minstack.getMin());
        System.out.println(minstack.top());
        minstack.pop();
        System.out.println(minstack.getMin());
        System.out.println(minstack.top());
    }
}
