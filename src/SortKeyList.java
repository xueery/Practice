public class SortKeyList {
    public static Node sortList(Node head,int x){
        Node big=null;
        Node small=null;
        Node biglast=null;
        Node smallast=null;
        Node cur=head;
        while(cur!=null){
            if(cur.val<x){
                if(small==null){
                    small=cur;
                }else{
                    smallast.next=cur;
                }
                smallast=cur;
            }
            else{
                if(big==null){
                    big=cur;
                }else{
                    biglast.next=cur;
                }
                biglast=cur;
            }
            cur=cur.next;
        }
        if(small==null) {
            return big;
        }else{
            smallast.next=big;
            if(biglast!=null){
                biglast.next=null;
            }
        }
        return small;
    }
    public static void disprint(Node head){
        for(Node cur=head;cur!=null;cur=cur.next){
            System.out.printf("%d-->",cur.val);
        }
        System.out.println("null");
    }
    public static Node Test(){
        Node n1=new Node(3);
        Node n2=new Node(1);
        Node n3=new Node(7);
        Node n4=new Node(0);
        Node n5=new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }
    public static void main(String[] args) {
        Node head=Test();
        head=sortList(head,4);
        disprint(head);
    }
}
