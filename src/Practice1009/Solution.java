package Practice1009;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/11 16:02
 */
public class Solution {
    //统计从0—n共出现2的次数
    public static int countNumberOf2s(int n) {
        // write code here
        long startTime=System.currentTimeMillis();
        int count = 1;
        for (int i = 11; i <= n; i++) {
            int a = i;
            while (a >=10) {
                int m = a % 10;
                if (m == 2) {
                    count=count+1;
                }
                a = a / 10;
                if (a == 2) {
                    count=count+1;
                }
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        return count;
    }
    //判断独一无二出现的次数（数组中没有出现次数相同的数）
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int count=map.getOrDefault(arr[i],0);
            map.put(arr[i],++count);
        }
        int[] nums=new int[map.size()];
        int count=0;
        for(int num:map.keySet()){
            nums[count++]=num;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(map.get(nums[i]))){
                set.add(map.get(nums[i]));
            }else {
                return false;
            }
        }
        return true;
    }
    //判断一个数是否为2的幂
    public static boolean isPowerOfTwo(int n) {
        for(int i=0;i<31;i++){
            double num=Math.pow(2,i);
            if(n==(int)num){
                return true;
            }
            if((int)num>n)break;
        }
        return false;
    }
    //移除数组中所有值为val的元素，返回数组的新长度（原地修改）
    public static int removeElement(int[] nums, int val) {
        int length=0;
        for(int i=0;i<nums.length;i++){
           if(nums[i]!=val) {
               nums[length++] = nums[i];
           }
        }
        return length;
    }
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode last=null;
        ListNode cur1=l1;
        ListNode cur2=l2;
        while(cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                if(head==null){
                    head=last=new ListNode(cur1.val);
                }else{
                    ListNode newNode=new ListNode(cur1.val);
                    last.next=newNode;
                    last=newNode;
                }
                cur1=cur1.next;
            }else{
                if(head==null){
                    head=last=new ListNode(cur2.val);
                }else{
                    ListNode newNode=new ListNode(cur2.val);
                    last.next=newNode;
                    last=newNode;
                }
                cur2=cur2.next;
            }
        }
        if(cur1!=null){
            if(head==null){
                head=cur1;
            }else {
                last.next = cur1;
            }
        }
        if(cur2!=null){
            if(head==null) {
                head=cur2;
            }else {
                last.next = cur2;
            }
        }
        return head;
    }
    //判断一个数是否为快乐树
    // 输入: 19
    //输出: true
    //解释:
    //1^2 + 9^2 = 82
    //8^2 + 2^2= 68
    //6^2 + 8^2 = 100
    //1^2 + 0^2 + 0^2 = 1
    public static boolean isHappy(int n) {
        List<Integer> list=new ArrayList<>();
        List<Double> l=new ArrayList<>();
        while(true) {
            double sum=0;
            while (n != 0) {
                int num = n % 10;
                list.add(num);
                n = n / 10;
            }
            for(int e:list){
               sum=sum+Math.pow(e,2);
            }
            list.clear();
            if(sum==1){
                return true;
            }else{
                n=(int)sum;
            }
            if(l.contains(sum)) {
                return false;
            }else{
                l.add(sum);
            }
        }
    }
    //搜索应插入的位置
    //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    // 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    public static int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        int index=(left+right+1)/2;
        return index;
    }
    //两个数组的交集
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=new HashSet<>();
        HashSet<Integer> set2=new HashSet<>();
        for(int num:nums1){
            set1.add(num);
        }
        for(int num:nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        int[] arr=new int[set2.size()];
        int count=0;
        for(int i:set2){
            arr[count++]=i;
        }
        return arr;
    }
    //去除链表中重复的结点，比如 : 1-->1-->1-->4-->4-->5  结果为:1-->4-->5
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode first=head;
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            while (next!=null && cur.val == next.val) {
                next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return first;
    }
    //给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词（这个方法写的有缺陷）
    //例如：输入: s = "anagram", t = "nagaram"
    //输出: true
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map1.getOrDefault(c,0);
            map1.put(c,++count);
        }
        for(char c:t.toCharArray()){
            int count=map2.getOrDefault(c,0);
            map2.put(c,++count);
        }
        if(map1.size()!=map2.size()){
            return false;
        }
        Set<Character> set= map2.keySet();
        for(char c:set){
            if(!map1.containsKey(c)){
                return false;
            }else {
                if (map1.get(c) != map2.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }
    ////给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
    public static boolean isAnagram2(String s,String r){
        char[] arr1=s.toCharArray();
        char[] arr2=r.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if(arr1.length!=arr2.length){
            return false;
        }
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public static ListNode buildList(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        return n1;
    }
    public static void disprint(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            if(cur.next!=null) {
                System.out.printf("%d-->", cur.val);
            }else{
                System.out.printf("%d",cur.val);
            }
            cur=cur.next;
        }
    }
    public static void main(String[] args) {
        int n=78889;
        System.out.println(countNumberOf2s(n));
        int[] array={1,2,2,3,3,2};
        System.out.println(uniqueOccurrences(array));
        System.out.println(isPowerOfTwo(2147483647));
        int[] nums={0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
        System.out.println(isHappy(18));
        int[] num={1,3,5,6};
        System.out.println(searchInsert(num,0));
        int[] arr1={4,9,5};
        int[] arr2={9,4,9,8,4};
        int[] result=intersection(arr1,arr2);
        System.out.println(Arrays.toString(result));
        ListNode head=buildList();
        head=deleteDuplicates(head);
        disprint(head);
        System.out.println();
        String s="car";
        String r="cat";
        System.out.println(isAnagram2(s,r));
    }

}
