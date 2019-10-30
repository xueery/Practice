package Practice1001;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:wangxue
 * @date:2019/10/1 9:49
 */
public class Solution {
    class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
      }
    }
    //将一个链表的val以从后往前的方式存入ArrayList中
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode rev=revese(listNode);
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode cur = rev; cur != null; cur = cur.next) {
            list.add(cur.val);
        }
        return list;
    }
    private ListNode revese(ListNode listNode) {
        ListNode cur=listNode;
        ListNode result=null;
        while(cur!=null) {
            ListNode last = cur.next;
            cur.next=result;
            result = cur;
            cur = last;
        }
        return result;
    }
    public ListNode buildTree(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;
    }
    public static void main(String[] args) {
        Solution s=new Solution();
        ListNode head=s.buildTree();
        System.out.println(s.printListFromTailToHead(head));
    }
}
