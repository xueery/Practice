package JavaEveryDayPractice56;
import JavaEveryDayPractice52.ListNode;

import java.util.*;
/**
 * @author:wangxue
 * @date:2020/4/28 11:03
 */
public class Main {
    //用一个辅助栈，将pushA中的元素加入，加入之后判断，加入的元素是否是popA的出栈元素
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 || popA.length==0){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[j]){
                j++;
                stack.pop();
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int length1=countLength(pHead1);
        int length2=countLength(pHead2);
        int length=length1-length2;
        ListNode headA=pHead1;
        ListNode headB=pHead2;
        if(length==0){
            while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
        }else if(length>0){
            for(int i=0;i<length;i++){
                headA=headA.next;
            }
            while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
        }else{
            length=-length;
            for(int i=0;i<length;i++){
                headB=headB.next;
            }
            while(headA!=headB){
                headA=headA.next;
                headB=headB.next;
            }
        }
        return headA;
    }
    public int countLength(ListNode head){
        ListNode cur=head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        int[] pushA={1,2,3,4,5};
        int[] popA={4,5,1,2,3};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
