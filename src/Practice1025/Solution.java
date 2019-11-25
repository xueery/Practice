package Practice1025;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/25 15:43
 */
public class Solution {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur=head;
        ListNode prev=new ListNode(0);
        prev.next=head;
        ListNode ret=prev;
        while(cur!=null){
            while(cur!=null && cur.val==val){
                cur=cur.next;
            }
            prev.next=cur;
            prev=cur;
            if(cur!=null) {
                cur = cur.next;
            }
        }
        return ret.next;
    }
    //给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
    //在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
    //注意：如果一个数出现奇数次，可以先取它的-1次，变成偶数
    public static int longestPalindrome(String s) {
        if(s==null){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(char c:s.toCharArray()){
            int count=map.getOrDefault(c,0);
            map.put(c,++count);
        }
        int longest=0;
        for(int c:map.values()){
            longest=longest+(c/2)*2;
        }
        //判断是否最长字符串为字符串长度，如果不相等，说明有出现奇数次的字符，
        // 可以加入一个字符在字符串最中间，也是回文字符串，构成最长字符串
        if(longest<s.length()){
            longest++;
        }
        return longest;
    }
    private static ListNode buildList(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        return n1;
    }
    private static void disprint(ListNode head){
        ListNode cur=head;
        while (cur!=null){
            System.out.println(cur.val+" ");
            cur=cur.next;
        }
    }
    //788.旋转数字：我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，
    // 我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
    //
    //如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
    // 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，
    // 除了这些以外其他的数字旋转以后都不再是有效的数字
    //
    //注意：是整个数都为好数，并不是每一位为好数
    public static int rotatedDigits(int N) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(2,1);
        map.put(5,1);
        map.put(6,1);
        map.put(9,1);
        map.put(1,0);
        map.put(3,-1);
        map.put(4,-1);
        map.put(7,-1);
        map.put(8,0);
        map.put(0,0);
        int sum=checkGoodNum(map,N);
        return sum;
    }

    private static int checkGoodNum(HashMap<Integer,Integer> map,int n) {
        int sum=0;
        for(int i=1;i<=n;i++){
            int a=i;
            boolean record=false;
            boolean breakR=false;
            while(a>0){
                int b=a%10;
                if(map.get(b)==-1){
                    breakR=true;
                    break;
                }
                if(map.get(b)==1){
                    record=true;
                }
                a=a/10;
            }
            if(!breakR && record){
                sum=sum+1;
            }
        }
        return sum;
    }
    //860.在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
    //
    //顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
    //每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
    // 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
    public static boolean lemonadeChange(int[] bills) {
        if(bills.length==0){
            return true;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int e:bills) {
            //如果付的是5块，不用找，直接加入钱箱就ok
            //每次先把收的钱加入到钱箱
            int count = map.getOrDefault(e, 0);
            map.put(e, ++count);
            //如果付的钱是10块
            if(e==10){
                int num5=map.getOrDefault(5,0);
                if(num5==0){
                    return false;
                }else{
                    //找给别人5块
                    num5--;
                    map.put(5,num5);
                }
                //如果付的钱是20
            }else if(e==20){
                int num5=map.getOrDefault(5,0);
                int num10=map.getOrDefault(10,0);
                //如果付的钱是20，必须有5块，要不然找不开
                if(num5==0){
                    return false;
                }else{
                    //如果收的钱没有10快的，看有没有3个5块，也可以找的开
                    if(num10==0){
                        if(num5<3){
                            return false;
                        }else{
                            //找给别人3个5块
                            num5=num5-3;
                            map.put(5,num5);
                        }
                    }else {
                        //有5块有10块，找给别人一个5块，一个10块
                        num5--;
                        num10--;
                        map.put(5, num5);
                        map.put(10, num10);
                    }
                }
            }
        }
        return true;
    }
    //682:棒球比赛：
    public static int calPoints(String[] ops) {
        if(ops.length==0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        for(String s:ops){
            if(s.equals("+")){
                int m=stack.pop();
                int n=stack.peek();
                stack.push(m);
                stack.push(m+n);
            }else if(s.equals("D")){
                stack.push(2*stack.peek());
            }else if(s.equals("C")){
                stack.pop();
            }else{
                stack.add(Integer.valueOf(s));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum=sum+stack.pop();
        }
        return sum;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode cur=head;
        ListNode result=null;
        while(cur!=null){
            ListNode node=cur.next;
            cur.next=result;
            result=cur;
            cur=node;
        }
        return result;
    }
    //二分查找
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    //724：我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
    //
    //如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        //先将整个数组添加到leftSum中
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            //向右走
            leftSum = leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            if(i < nums.length){
                //加左边的
                rightSum = rightSum + nums[i];
            }
        }
        return -1;
    }
    //575:分糖果
    //给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
    //你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
    public static int distributeCandies(int[] candies) {
        HashSet<Integer> set=new HashSet<>();
        for(int e:candies){
            set.add(e);
        }
        if(set.size()>=candies.length/2){
            return candies.length/2;
        }else{
            return set.size();
        }
    }
    //数组拆分
    public static int arrayPairSum(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++,i++){
            sum=sum+nums[i];
        }
        return sum;
    }
    //605:种花：假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
    // 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
    //
    //给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。
    // 能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1 && flowerbed[0]==0 && n==1){
            return true;
        }
        int i=0;
        int sum=0;
        while(i<flowerbed.length-1) {
            if (flowerbed[i] == 0) {
                int j = i + 1;
                if(i==0 || i==flowerbed.length-2) {
                    if (flowerbed[j]==0){
                        sum++;
                        i=i+2;
                        continue;
                    }
                }
                if (i<flowerbed.length-2 && flowerbed[j] == 0 && flowerbed[j + 1] == 0) {
                    sum++;
                    i=i+2;
                    continue;
                }
            }
            i++;
        }
        if(sum>=n){
            return true;
        }
        return false;
    }
    //594: 最长和谐子序列
    public static int findLHS(int[] nums) {
        if(nums.length==0 || nums.length==1){
            return nums.length;
        }
        Arrays.sort(nums);
        int i=0;
        int max=0;
        while(i<nums.length-1){
            int record=i;
            while(i<nums.length-1 && nums[i]==nums[i+1]){
                i++;
            }
            i++;
            if(record==0 && i== nums.length){
                return 0;
            }
            int j=i;
            while(j<nums.length-1 && nums[j]==nums[j+1]){
               j++;
            }
            j++;
            if(max<j-record && nums[i]-nums[record]==1){
                max=j-record;
            }
        }
        return max;
    }
    //链表的中间结点
    public ListNode middleNode(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
        }
        return slow;
    }
    //747:至少是其他数字两倍的数
    public int dominantIndex(int[] nums) {
        if(nums.length==1){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
                index=i;
            }
        }
        for(int e:nums){
            if(max>e && secondMax<e){
                secondMax=e;
            }
        }
        if(max>=2*secondMax){
            return index;
        }
        return -1;
    }
    //821.字符最短距离
    public int[] shortestToChar1(String S, char C) {
        int[] ret=new int[S.length()];
        //存放字符c在S中出现的下标
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==C){
                list.add(i);
            }
        }
        for(int i=0;i<S.length();i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<list.size();j++){
                //得到每个字符和字符串中字符C的距离，选出最小的，存入数组中
                if(min>Math.abs(list.get(j)-i)){
                    min=Math.abs(list.get(j)-i);
                }
            }
            ret[i]=min;
        }
        return ret;
    }

    /*
    public int twoCitySchedCost(int[][] costs) {
        int[] arr1=new int[costs.length];
        int[] arr2=new int[costs.length];
        for(int i=0;i<costs.length;i++){
            for(int j=0;j<costs[i].length;j++){

            }
        }
    }
    */

    public static void main(String[] args) {
        ListNode head=buildList();
        head=removeElements(head,1);
        disprint(head);

        String s="abbbccccll";
        System.out.println(longestPalindrome(s));
        System.out.println(rotatedDigits(857));
        int[] bills={5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(bills));
        int[] nums={1,1,3,1,1};
        System.out.println(pivotIndex(nums));
        String[] strings={"5","2","C","D","+"};
        System.out.println(calPoints(strings));
        int[] candies={1,1,2,3};
        System.out.println(distributeCandies(candies));
        int[] nums1={1,2,3,4};
        System.out.println(arrayPairSum(nums1));
        int[] flowerbed={0,0,1,0,0};
        System.out.println(canPlaceFlowers(flowerbed,2));
        int[] nums2={1,3,5};
        System.out.println(findLHS(nums2));
    }
}
