package Practice0823;

public class CircularQueue {
    private int[] array;
    private int front=0;
    private int rear=0;
    private int size=0;
    public CircularQueue(int k){
        array=new int[k];
    }
    //插入
    public boolean enQueue(int value){
        if(size==array.length){
            return false;
        }
        array[rear]=value;
        rear=(rear+1)%array.length;
        size++;
        return true;
    }
    //删除
    public boolean deQueue(){
        if(size==0){
            return false;
        }
        front=(front+1)%array.length;
        size--;
        return true;
    }
    //获取队头元素
    public int front(){
        if(size==0){
            return -1;
        }
        return array[front];
    }
    //获取队尾元素
    public int rear(){
        if(size==0){
            return -1;
        }
        return array[(rear-1+array.length)%array.length];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return array.length==size;
    }
    public void printQueue(){
        int length=size;
        int pre=front;
        System.out.print("[");
        while(length!=0){
            System.out.printf("%d,",array[pre]);
            pre=(pre+1)%array.length;
            length--;
        }
        System.out.println("]");
    }
}
