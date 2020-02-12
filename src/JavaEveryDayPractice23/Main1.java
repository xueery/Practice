package JavaEveryDayPractice23;

/**
 * @author:wangxue
 * @date:2019/11/30 10:45
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main1 {
    public static ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        int num1=0;
        int num2=0;
        ListNode cur1=a;
        ListNode cur2=b;
        int i=0;
        while(cur1!=null){
            if(i==0){
                num1= cur1.val;
                i++;
            }else {
                num1 = num1 + cur1.val * (int)Math.pow(10,i++);
            }
            cur1=cur1.next;
        }
        i=0;
        while(cur2!=null){
            if(i==0){
                num2=cur2.val;
                i++;
            }else {
                num2 = num2 + cur2.val * (int)Math.pow(10,i++);
            }
            cur2=cur2.next;
        }
        int sum=num1+num2;
        ListNode ret=null;
        ListNode next=null;
        while(sum!=0){
            int n=sum%10;
            ListNode node=new ListNode(n);
            if(ret==null){
                ret=node;
            }else{
                next.next=node;
            }
            next=node;
            sum/=10;
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode m1=new ListNode(3);
        ListNode m2=new ListNode(2);
        ListNode m3=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        m1.next=m2;
        m2.next=m3;
        System.out.println(plusAB(n1,m1));
    }
}
