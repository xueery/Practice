package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/18 10:52
 */
// 链表中倒数第 k 个结点
public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head==null)return null;
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<k;i++){
            // 判断 k 如果大于链表的长度
            if(fast!=null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
