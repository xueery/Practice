package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/18 10:55
 */
// 反转链表
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null)return null;
        ListNode cur=head;
        ListNode newHead=null;
        while (cur!=null){
            ListNode node=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=node;
        }
        return newHead;
    }
}
