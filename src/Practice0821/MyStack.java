package Practice0821;

import java.util.Arrays;

public class MyStack {
    private int[] array=new int[10];
    private int top=0;
    private void ensureCapacity(){
        if(top<array.length){
            return;
        }
        array= Arrays.copyOf(array,2*array.length);
    }
    public int push(int element){
        ensureCapacity();
        array[top++]=element;
        return element;
    }
    public int pop(){
        return array[--top];
    }
    public int size(){
        return top;
    }
    public boolean isEmpty(){
        return top==0;
    }
    public int peek(){
        return array[top-1];
    }
    public int search(int element){
        for(int i=0;i<top;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }
}
