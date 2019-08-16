import java.net.SocketPermission;

class Node{
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{"+
                "val"+val+
                "}";
    }
}
public class Interview0815 {
    //返回链表的中间结点
    public static Node getMiddleNode(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //返回链表倒数第k个节点
    public static Node getKthNode(Node head,int k){
        Node fast=head;
        Node slow=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //以给定值x为基准分割，所有小于x的排在大于x的前面
    public static Node sortList(Node head,int x){
        Node smallList=null;
        Node bigList=null;
        Node smallast=null;
        Node biglast=null;
        Node cur=head;
        while(cur!=null){
            if(cur.val>x){
                if(bigList==null){
                    bigList=cur;
                }
                else{
                    biglast.next=cur;
                }
                biglast=cur;
            }
            else{
               if(smallList==null){
                   smallList=cur;
               }
               else{
                   smallast.next=cur;
               }
               smallast=cur;
            }
            cur=cur.next;
        }
        if(smallList==null){
            return bigList;
        }
        else{
            smallast.next=bigList;
            if(biglast!=null){
                biglast.next=null;
            }
        }
        return smallList;
    }
    //删除链表中等于给定值val的所有结点
    public static Node removeAllVal(Node head,int key){
        Node prev=new Node(0);
        Node cur=head;
        prev.next=head;
        Node last=prev;
        while(cur!=null){
            if(cur.val!=key){
                last=cur;
            }
            else{
                last.next=cur.next;
            }
            cur=cur.next;
        }
        return prev.next;
    }
    //逆置链表
    public static Node reverse(Node head){
        Node cur=head;
        Node newList=null;
        Node next=null;
        while(cur!=null){
            next=cur.next;
            cur.next=newList;
            newList=cur;
            cur=next;
        }
        return newList;
    }
    //判断是否为回文链表
    public static boolean judplaList(Node head){
        Node cur=head;
        Node middleNode=getMiddleNode(cur);
        Node revList=reverse(middleNode);
        while(revList!=null){
            if(cur.val!=revList.val){
                return false;
            }
            cur=cur.next;
            revList=revList.next;
        }
        return true;
    }
    //合成两个有序链表
    public static Node mergeList(Node head1,Node head2){
        Node cur1=head1;
        Node cur2=head2;
        Node newList=null;
        Node last=null;
        while(cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                if(newList==null){
                    newList=cur1;
                }
                else{
                    last.next=cur1;
                }
                last=cur1;
                cur1=cur1.next;
            }
            else{
                if(newList==null){
                    newList=cur2;
                }
                else{
                    last.next=cur2;
                }
                last=cur2;
                cur2=cur2.next;
            }
        }
        return newList;
    }
    public static void disprint(Node head){
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.printf("%d-->",cur.val);
        }
        System.out.println("null");
    }
    public static Node Test1(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(2);
        Node n4=new Node(3);
        Node n5=new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static Node Test2(){
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
    public static Node Test3(){
        Node n1=new Node(9);
        Node n2=new Node(8);
        Node n3=new Node(3);
        Node n4=new Node(8);
        Node n5=new Node(9);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static void main(String[] args) {
        Node head1=Test1();
        for(Node c=head1;c!=null;c=c.next){
            System.out.println(c);
        }
        Node retMiddle=getMiddleNode(head1);
        System.out.println(retMiddle.val);
        Node retKth=getKthNode(head1,5);
        System.out.println(retKth.val);
        Node head2=Test2();
        Node retMergeList=mergeList(head1,head2);
        disprint(retMergeList);
        Node head3=Test3();
        Node retsortList=sortList(head3,6);
        disprint(retsortList);
        boolean retpla=judplaList(head3);
        if(retpla==true) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        Node retremove=removeAllVal(head1,2);
        disprint(retremove);
        head1=reverse(head1);
        disprint(head1);
    }
}
