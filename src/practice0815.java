public class practice0815 {
    //删除一个链表中重复的结点
    public static Node removerepeNode(Node head){
        Node p1=head;
        Node p2=head.next;
        Node prev=null;
        while(p2!=null){
            if(p1.val!=p2.val){
                prev=p1;
                p1=p1.next;
                p2=p2.next;
            }
            else{
                while(p2!=null && p2.val==p1.val){
                    p2=p2.next;
                }
                if(prev==null){
                    head=p2;
                }
                else{
                    prev.next=p2;
                }
                p1=p2;
                if(p2!=null){
                    p2=p2.next;
                }
            }
        }
        return head;
    }
    //判断链表是否为环
    public static boolean judListloop(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        if(fast==null){
            return false;
        }
        else{
            return true;
        }
    }
    // 判断链表入环的第一个结点，如果无环，返回null
    public static Node judList(Node head){
        if(head==null){
            return null;
        }
        Node fast=head;
        Node slow=head;
        do{
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }while(fast!=null && fast!=slow);
        if(fast==null){
            return null;
        }
        Node p1=head;
        Node p2=fast;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
    //求链表的长度
    public static int getLength(Node head){
        Node cur=head;
        int length=0;
        while(cur!=null){
            cur=cur.next;
            length++;
        }
        return length;
    }
    //找两个链表的第一个公共结点
    //利用公共结点之后的长度相同的特点
    public static Node getComTwoList(Node head1,Node head2){
        int length1=getLength(head1);
        int length2=getLength(head2);
        Node cur1=head1;
        Node cur2=head2;
        while(length1>length2){
            cur1=cur1.next;
            length1--;
        }
        while(length1<length2){
            cur2=cur2.next;
            length2--;
        }
        if(cur1!=cur2){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }
    public static void disprint(Node head){
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.printf("%d-->",cur.val);
        }
        System.out.println("null");
    }
    public static Node Test1(){
        Node n1=new Node(0);
        Node n2=new Node(2);
        Node n3=new Node(2);
        Node n4=new Node(4);
        Node n5=new Node(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static Node Test2(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(5);
        Node n5=new Node(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n2;
        return n1;
    }
    public static void main(String[] args) {
        Node head1=Test1();
        Node retNode=removerepeNode(head1);
        disprint(retNode);
        Node head2=Test2();
        boolean judLoop=judListloop(head2);
        if(judLoop==true){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        Node ret=judList(head2);
        System.out.println(ret.val);
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(5);
        Node n5=new Node(6);
        Node m1=new Node(8);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        m1.next=n4;
        Node retComNode=getComTwoList(n1,m1);
        System.out.println(retComNode.val);
    }
}
