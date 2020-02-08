package JavaEveryDayPractice21;

/**
 * @author:wangxue
 * @date:2019/11/27 19:26
 */
class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
public class Partition {
    public static ListNode partition(ListNode pHead, int x) {
        if(pHead==null || pHead.next==null){
            return pHead;
        }
        // write code here
        ListNode smallHead=null;
        ListNode smallLast=null;
        ListNode bigHead=null;
        ListNode bigLast=null;
        ListNode cur=pHead;
        while(cur!=null){
            if(cur.val<x){
                if(smallHead==null){
                    smallHead=cur;
                }else{
                    smallLast.next=cur;
                }
                smallLast=cur;
            }else{
                if(bigHead==null){
                    bigHead=cur;
                }else{
                    bigLast.next=cur;
                }
                bigLast=cur;
            }
            cur=cur.next;
        }
        if(smallHead!=null){
            smallLast.next=bigHead;
            //必须判断bigHead为不为空，如果不为空，则将bigLast.next置为null
            if(bigHead!=null) {
                bigLast.next = null;
            }
            return smallHead;
        }else{
            bigLast.next=null;
            return bigHead;
        }
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(3);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(5);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(1);
        ListNode n6=new ListNode(7);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        System.out.println(partition(n1,4));
    }
}
