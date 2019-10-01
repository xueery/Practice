package Practice0904;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/9/5 20:07
 */
public class CopyComplexList {
    //复制复杂链表
    //思路：先复制next链表，不复制random，建立映射
    //再根据映射关系，复制random
    public static Node copComplexList(Node head){
        Node p=head;
        Node prev=null;
        Node last=null;
        Map<Node,Node> map=new HashMap<>();
        while(p!=null){
            Node q=new Node(p.val);
            if(prev==null){
                prev=q;
            }else{
                last.next=q;
            }
            last=q;
            map.put(p,q);
            p=p.next;
        }
        p=head;
        Node q=prev;
        while(p!=null){
            q.random=map.get(p.random);
            p=p.next;
            q=q.next;
        }
        return prev;
    }
    public static void disprint(Node head){
        Node cur=head;
        while(cur!=null) {
            System.out.printf("Node%d  ", cur.val);
            if(cur.next!=null){
                int val=cur.next.val;
                System.out.printf("next(%d)",val);
            }else{
                System.out.printf("next(null)");
            }
            if(cur.random!=null){
                int val=cur.random.val;
                System.out.printf("random(%d)%n",val);
            }else{
                System.out.printf("random(null)%n");
            }
            cur=cur.next;
        }
    }
    public static Node buildList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n1.random=n3;
        n3.random=n4;
        n4.random=n6;
        return n1;
    }
    public static void main(String[] args) {
        Node head=buildList();
        Node result=copComplexList(head);
        disprint(result);
    }
}