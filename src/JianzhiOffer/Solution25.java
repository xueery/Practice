package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/27 10:20
 */
// 复制复杂链表
public class Solution25 {
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null)return null;
        // 旧链表和新链表连接起来
        RandomListNode cur=pHead;
        while (cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            node.next=cur.next;
            cur.next=node;
            cur=cur.next.next;
        }
        // 复制
        cur=pHead;
        while (cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        // 拆分
        cur=pHead;
        RandomListNode newList=cur.next;
        while (cur!=null){
            RandomListNode node=cur.next;
            cur.next=node.next;
            if(node.next!=null){
                node.next=node.next.next;
            }
            cur=cur.next;
        }
        return newList;
    }
}
