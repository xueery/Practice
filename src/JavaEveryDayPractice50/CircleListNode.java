package JavaEveryDayPractice50;

/**
 * @author:wangxue
 * @date:2020/3/25 16:21
 */
public class CircleListNode {
    //判断链表是否有环
    public static ListNode checkListNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return fast;
            }
        }
        return null;
    }

    //判断环的长度
    public static int lengthListNode(ListNode head){
        ListNode cur=checkListNode(head);
        ListNode fast=cur;
        ListNode slow=cur;
        int count=0;
        while(fast!=null){
            fast=fast.next;
            count++;
            if(fast==slow){
                break;
            }
        }
        return count;
    }

    //查找有环链表的入口
    public static ListNode searchFirstEnter(ListNode head){
        if(head==null){
            return null;
        }
        ListNode cur1=checkListNode(head);
        ListNode cur2=head;
        if(cur1!=null) {
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return cur1;
    }
}
