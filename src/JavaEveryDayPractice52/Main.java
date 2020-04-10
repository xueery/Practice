package JavaEveryDayPractice52;

/**
 * @author:wangxue
 * @date:2020/3/30 13:33
 */
public class Main {
    public static String strngLeftRotate(String s,int n){
        int k=n%s.length();
        StringBuilder sb=new StringBuilder();
        for(int i=k;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<=k-1;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static ListNode delRepeList(ListNode head){
        ListNode prev=null;
        if(head==null){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head.next;
        while(p2!=null){
            if(p1.val!=p2.val){
                prev=p1;
                p1=p2;
                p2=p2.next;
            }else{
                while(p2!=null && p1.val==p2.val){
                    p2=p2.next;
                }
                if(prev==null){
                    head=p2;
                }else{
                    prev.next=p2;
                }
                p1=p2;
                if(p2!=null){
                    p2=p2.next;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        String s="wangxue";
        System.out.println(strngLeftRotate(s,4));
    }
}
