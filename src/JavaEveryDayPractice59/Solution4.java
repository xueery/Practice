package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/17 20:17
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution4 {
    // 复制复杂链表
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        //先将旧链表和新链表连接起来
        RandomListNode cur=pHead;
        while(cur!=null){
            RandomListNode node=new RandomListNode(cur.label);
            node.next=cur.next;
            cur.next=node;
            cur=cur.next.next;
        }
        // 进行复制
        cur=pHead;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }else{
                cur.next.random=null;
            }
            cur=cur.next.next;
        }
        //拆分旧链表和新链表
        cur=pHead;
        RandomListNode newList=cur.next;
        while(cur!=null){
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
