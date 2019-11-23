package Practice1023;

import com.sun.imageio.plugins.common.I18N;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/23 16:37
 */
public class Solution {
    //108:将有序数组转换为高度平衡二叉搜索树
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }
    private static TreeNode build(int[] nums,int left,int right) {
        if(left>right){
            return null;
        }
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=build(nums,left,mid-1);
        root.right=build(nums,mid+1,right);
        return root;
    }
    //最大收益
    public static int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }
        int max=0;
        for(int i=prices.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                int profit=prices[i]-prices[j];
                if(profit>0){
                    if(profit>max) {
                        max = prices[i] - prices[j];
                    }
                }
            }
        }
        return max;
    }
    //给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle
    // 字符串出现的第一个位置 (从0开始)。如果不存在，则返回-1
    public static int strStr(String haystack, String needle) {
        //判断haystack字符串为空但needle字符串不为空，返回-1
        if(haystack.length()==0 && needle.length()!=0){
            return -1;
        }
        //判断haystack字符串不为空但needle字符串为空，返回0
        if(haystack.length()!=0 && needle.length()==0){
            return 0;
        }
        //判断haystack字符串为空但needle字符串为空，返回0
        if(haystack.length()==0 && needle.length()==0){
            return 0;
        }
        char[] hay=haystack.toCharArray();
        char[] need=needle.toCharArray();
        int index=0;
        for(int i=0;i<hay.length;i++){
            if(hay[i]==need[0]){
                index=i;
                if(hay.length-i>=needle.length()) {
                    String s = haystack.substring(index, index + needle.length());
                    if (s.equals(needle)) {
                        return index;
                    }
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }
    //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，
    //这条路径上所有节点值相加等于目标和。
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return sum==root.val;
        }
        return hasPathSum(root.left,sum-root.val) ||
                hasPathSum(root.right,sum-root.val);
    }
    //反转二叉树（左右孩子交换）
    public static TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    //找二叉搜索树的公共祖先
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if((root.val>=p.val && root.val<=q.val) || (root.val<=p.val && root.val>=q.val)){
            return root;
        }else if(root.val>p.val && root.val>q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }
    private static TreeNode buildTree1(){
        TreeNode root=new TreeNode(90);
        TreeNode n1=new TreeNode(69);
        TreeNode n2=new TreeNode(49);
        TreeNode n3=new TreeNode(89);
        TreeNode n4=new TreeNode(52);
        root.left=n1;
        n1.left=n2;
        n1.right=n3;
        n2.right=n4;
        return root;
    }
    //697:给定一个非空且只包含非负数的整数数组 nums,
    //数组的度的定义是指数组里任一元素出现频数的最大值。
    //你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
    public static int findShortestSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<nums.length;i++){
            int count=map.getOrDefault(nums[i],0);
            map.put(nums[i],++count);
        }
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(max<e.getValue()){
                max=e.getValue();
            }
        }
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(max==e.getValue()){
                list.add(e.getKey());
            }
        }
        int minlength=nums.length;
        for(int i=0;i<list.size();i++){
            int left=0;
            int right= nums.length-1;
            while(left<=right) {
                while(left<=right && nums[left]!=list.get(i)){
                    left++;
                }
                while(left<=right && nums[right]!=list.get(i)){
                    right--;
                }
                if(minlength>right-left){
                    minlength=right-left+1;
                }
                break;
            }
        }
        return minlength;
    }
    //给定二叉搜索树（BST）的根节点和一个值。
    // 你需要在BST中找到节点值等于给定值的节点。
    // 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        TreeNode root1;
        if(root.val==val){
            return root;
        }else if(root.val>val){
            root1=searchBST(root.left,val);
        }else{
            root1=searchBST(root.right,val);
        }
        return root1;
    }
    //783：给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
    public static int minDiffInBST(TreeNode root) {
        //利用中序遍历,可以得到一个有序顺序表
        int ret=orderTraversal(root);
        return ret;
    }

    private static int orderTraversal(TreeNode root) {
        List<Integer> ret=order(root);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<ret.size();i++){
            if(min>ret.get(i)-ret.get(i-1)){
                min=ret.get(i)-ret.get(i-1);
            }
        }
        return min;
    }

    private static List<Integer> order(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> list=new ArrayList<>();
        List<Integer> left=order(root.left);
        List<Integer> right=order(root.right);
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }
    //一棵树的坡度
    public static int findTilt(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=findTilt(root.left);
        int right=findTilt(root.right);
        int sum=0;
        if(root.left!=null && root.right==null) {
            sum =root.left.val + left;
        }
        if(root.left==null && root.right!=null) {
            sum =root.right.val + right;
        }
        if(root.left!=null && root.right!=null) {
            sum = Math.abs(root.left.val + left - root.right.val - right) + left + right;
        }
        return sum;
    }
    //965：单值二叉树
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        int val=root.val;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur.left!=null){
                if(cur.left.val!=val){
                    return false;
                }
                queue.add(cur.left);
            }
            if(cur.right!=null){
                if(cur.right.val!=val){
                    return false;
                }
                queue.add(cur.right);
            }
        }
        return true;
    }
    //657：机器人能否回到原点
    public boolean judgeCircle(String moves) {
        if(moves.length()==0){
            return true;
        }
        //分别存上下左右
        int[] arr=new int[4];
        for(char c:moves.toCharArray()){
            if(c=='U'){
                arr[0]++;
            }
            if(c=='D'){
                arr[1]++;
            }
            if(c=='L'){
                arr[2]++;
            }
            if(c=='R'){
                arr[3]++;
            }
        }
        if(arr[0]!=arr[1]){
            return false;
        }
        if(arr[2]!=arr[3]){
            return false;
        }
        return true;
    }
    //子除数
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(checkNumber(i)){
                list.add(i);
            }
        }
        return list;
    }

    private static boolean checkNumber(int n) {
        int num=n;
        while(num>0){
            int a=num%10;
            if(a==0){
                return false;
            }
            if(n%a!=0){
                return false;
            }
            num=num/10;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        int[] nums={-10,-3,0,5,9};
        TreeNode root=sortedArrayToBST(nums);
        System.out.println(root);
        int[] prices={1,4,3};
        System.out.println(maxProfit(prices));
        String hay="a";
        String need="";
        System.out.println(strStr(hay,need));
        int[] arr={1,2,2,3,1};
        System.out.println(findShortestSubArray(arr));
        */

        //TreeNode root=buildTree1();
        //invertTree(root1);
        /*
        TreeNode root=lowestCommonAncestor(root1,new TreeNode(1),new TreeNode(2));
        System.out.println(root.val);
        */
        //System.out.println(searchBST(root,7).val);
        //System.out.println(minDiffInBST(root));
        //System.out.println(findTilt(root));
        System.out.println(selfDividingNumbers(1,22));
    }
}
