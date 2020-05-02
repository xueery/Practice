package Holiday15;

import javax.sql.rowset.serial.SerialStruct;
import java.io.CharConversionException;
import java.util.*;


/**
 * @author:wangxue
 * @date:2020/2/5 11:00
 */
public class Main {
    //461:汉明距离
    public int hammingDistance(int x, int y) {
        String s1=Integer.toBinaryString(x);
        String s2=Integer.toBinaryString(y);
        if(s1.length()>s2.length()){
            StringBuilder s=new StringBuilder(s2);
            for(int i=0;i<s1.length()-s2.length();i++){
                s.append('0');
            }
            s.append(s2);
            s2=s.toString();
        }else{
            StringBuilder s=new StringBuilder(s2);
            for(int i=0;i<s2.length()-s1.length();i++){
                s.append('0');
            }
            s.append(s1);
            s1=s.toString();
        }
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
            }
        }
        return count;
    }
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if((n&1)!=0){
                count++;
            }
            //应该使用无符号右移，避免若为负数，最高位一直补1，导致死循环
            n>>>=1;
        }
        return count;
    }

    //551:学生出勤记录
    public boolean checkRecord(String s) {
        int count=0;
        for(char c:s.toCharArray()){
            if(c=='A'){
                count++;
            }
        }
        if(count>1 || s.contains("LLL")){
            return false;
        }else{
            return true;
        }
    }

    //598:范围求和
    public int maxCount(int m, int n, int[][] ops) {
        int minRow=m;
        int minCol=n;
        for(int i=0;i<ops.length;i++){
            for(int j=0;j<2;j++){
                minRow=Math.min(ops[i][0],minRow);
                minCol=Math.min(ops[i][1],minCol);
            }
        }
        return minCol*minRow;
    }

    public int subtractProductAndSum(int n) {
        int mul=1;
        int sum=0;
        while(n!=0){
            int m=n%10;
            mul*=m;
            sum+=m;
            n/=10;
        }
        return mul-sum;
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:cpdomains){
            String[] strings1=s.split(" ");
            int number=Integer.parseInt(strings1[0]);
            while(true){
                int count=map.getOrDefault(strings1[1],0);
                map.put(strings1[1],count+number);
                int index=strings1[1].indexOf(".");
                if(index!=-1) {
                    strings1[1] = strings1[1].substring(index + 1, strings1[1].length());
                }else{
                    break;
                }
            }
        }
        List<String> list=new ArrayList<>();
        for(Map.Entry<String,Integer> m:map.entrySet()){
            int n=m.getValue();
            list.add(String.valueOf(n)+" "+m.getKey());
        }
        return list;
    }

    public int balancedStringSplit(String s) {
        int count=0;
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(!stack.isEmpty()){
                if(stack.peek()==s.charAt(i)){
                    stack.push(s.charAt(i));
                    count--;
                }else{
                    stack.pop();
                    count++;
                }
            }else{
                stack.push(s.charAt(i));
            }
        }
        return count;
    }

    public int addDigits(int num) {
        while(true) {
            int sum=0;
            while(num!=0) {
                int n = num % 10;
                sum+=n;
                num /= 10;
            }

            if(sum<10){
                return sum;
            }else{
                num=sum;
            }
        }
    }

    public boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        //设置为long是因为int型有可能越界
        long left=2;
        long right=num/2;
        while(left<=right){
            long mid=(left+right)/2;
            if(mid*mid==num){
                return true;
            }else if(mid*mid>num){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;
    }

    public int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }


    private ListNode reverseList(ListNode head){
        ListNode newNode=head;
        ListNode cur=head;
        while(cur!=null){
            ListNode node=cur.next;
            cur.next=newNode;
            newNode=cur;
            cur=node;
        }
        return newNode;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=getLength(headA);
        int lengthB=getLength(headB);
        ListNode curA=headA;
        ListNode curB=headB;
        if(lengthA>lengthB){
            int length=lengthA-lengthB;
            while (length>0){
                length--;
                curA= curA.next;
            }
        }else if(lengthA<lengthB){
            int length=lengthB-lengthA;
            while (length>0){
                length--;
                curB=curB.next;
            }
        }
        while (curA!=null && curB!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }

    private int getLength(ListNode head){
        if(head==null){
            return 0;
        }
        int length=0;
        ListNode cur=head;
        while(cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }

    public static ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode newNode=null;
        while(cur!=null){
            ListNode node=cur.next;
            cur.next=newNode;
            newNode=cur;
            cur=node;
        }
        return newNode;
    }
    public static void main(String[] args) {
        String[] strings={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(strings));
    }
}
