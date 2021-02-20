package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/18 10:55
 */
// 合并两个排序的链表
public class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null && list2==null)return null;
        if(list1==null)return list2;
        if(list2==null)return list1;
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode head=null;
        ListNode last=null;
        while (p1!=null && p2!=null){
            if(p1.val<p2.val){
                if(head==null){
                    head=new ListNode(p1.val);
                    last=head;
                }else{
                    last.next=new ListNode(p1.val);
                    last=last.next;
                }
                p1=p1.next;
            }else{
                if(head==null){
                    head=new ListNode(p2.val);
                    last=head;
                }else{
                    last.next=new ListNode(p2.val);
                    last=last.next;
                }
                p2=p2.next;
            }
        }
        if (p1!=null){
            last.next=p1;
        }
        if (p2!=null){
            last.next=p2;
        }
        return head;
    }
}

