
package JavaEveryDayPractice54;
import java.util.*;

/**
 * @author:wangxue
 * @date:2020/4/7 13:55
 */
class ListNode{
    int val;
    ListNode left;
    ListNode right;
    public ListNode(int val){
        this.val=val;
    }
    public ListNode(int val,ListNode left,ListNode right){
        this.left=left;
        this.val=val;
        this.right=right;
    }
}
public class Main {
    public static int height(ListNode root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int h=Math.max(left,right)+1;
        return h;
    }
    public static boolean isBalanced(ListNode root){
        if(root==null){
            return true;
        }
        boolean left=isBalanced(root.left);
        if(!left){
            return false;
        }
        boolean right=isBalanced(root.right);
        if(!right){
            return false;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.left);
        int h=leftHeight-rightHeight;
        if(h>=1 || h<=-1){
            return false;
        }
        return true;
    }
    public static ListNode search(ListNode root,int val){
        if(root==null){
            return null;
        }
        ListNode cur=root;
        while(cur!=null){
            if(val==cur.val){
                return cur;
            }else if(val>cur.val){
                cur=cur.right;
            }else{
                cur=cur.left;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int rootNum = scanner.nextInt();
        int n1,n2,n3;
        ListNode root=null;
        for(int i=0;i<n/3;i++){
            n1=scanner.nextInt();
            n2=scanner.nextInt();
            n3=scanner.nextInt();
            if(n2==rootNum){
                root=new ListNode(n2);
                if(n1==0){
                    root.left=new ListNode(n1);
                }else{
                    root.left=null;
                }
                if(n3==0){
                    root.right=new ListNode(n3);
                }else{
                    root.right=null;
                }
                continue;
            }
            ListNode cur=search(root,n2);
            if(cur!=null) {
                if (n1 != 0) {
                    cur.left = new ListNode(n1);
                } else {
                    cur.left = null;
                }
                if (n3 != 0) {
                    cur.right = new ListNode(n3);
                } else {
                    cur.right = null;
                }
            }
        }
        if(isBalanced(root)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

