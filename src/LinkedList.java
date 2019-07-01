public class LinkedList extends AbstractList implements List {
    private static class Node{
        private int val;
        private Node next;
        Node(int val){
            this.val=val;
        }
        Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
    private class LinkedListIterator implements Iterator{
        Node cur=head;
        public boolean hasNext(){
            return cur!=null;
        }
        public int next(){
            int val=cur.val;
            cur=cur.next;
            return val;
        }
    }
    Node head=null;
    public Iterator iterator(){
        return new LinkedListIterator();
    }
    public void insertInternal(int index,int val){
        Node cur=head;
        if(index==0){
            head=new Node(val,head);
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }

            cur.next = new Node(val, cur.next);
        }
    }
    public void popCurrent(int index){
        Node cur=head;
        if(index==0){
            head=head.next;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
    }
}
