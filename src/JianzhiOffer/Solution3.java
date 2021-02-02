package JianzhiOffer;

import java.util.ArrayList;

/**
 * @author:wangxue
 * @date:2021/2/2 23:17
 */
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}


public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null)return new ArrayList<>();
        ListNode newHead=reverse(listNode);
        ArrayList<Integer> list=new ArrayList<>();
        ListNode cur=newHead;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        return list;
    }
    public ListNode reverse(ListNode head){
        if(head==null){return null;}
        ListNode newHead=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode node=cur.next;
            cur.next=newHead;
            newHead=cur;
            cur=node;
        }
        return newHead;
    }
}
