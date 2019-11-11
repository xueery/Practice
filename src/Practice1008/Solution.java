package Practice1008;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/8 8:33
 */
public class Solution {
    //找出数组中第三大的数
    public static int thirdMax(int[] nums) {
        //用hashSet先去重
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        //将set中的元素挪到数组中
        int[] array=new int[set.size()];
        int i=0;
        for(int s:set){
            array[i++]=s;
        }
        //对数组进行排序，再找出最三大最值
        Arrays.sort(array);
        if(array.length>=3){
            return array[array.length-3];
        }
        return array[array.length-1];
    }

    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list=inorderTraversal(root);
        TreeNode head=new TreeNode(list.get(0));
        TreeNode cur=head;
        for(int i=1;i<list.size();i++){
            cur.right=new TreeNode(list.get(i));
            cur=cur.right;
        }
        return head;
    }
    //下一个更大的元素(下一个指下标相同及之后的元素中有无与该下标处元素大的元素）
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=i;j<nums2.length;j++){
                if(nums1[i]<nums2[j]){
                    nums[i]=nums2[j];
                    break;
                }
                if(j==nums2.length-1 && nums1[i]>=nums2[j]){
                    nums[i]=-1;
                }
            }
        }
        return nums;
    }
    //下一个更大的元素(下一个指数组中与他相同的元素之后的元素中有无与他大的）
    public static int[] nextGreaterElement2(int[] nums1,int[] nums2){
        if(nums2.length==0){
            return new int[0];
        }
        //先构造一个栈，存放nums2中的元素
        // 如果大于栈中的数，则出栈存入map中，Key对应出栈的元素，value对应比栈中元素大的数字
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        stack.push(nums2[0]);
        for(int i=1;i<nums2.length;i++){
            while(!stack.isEmpty()&& nums2[i]>stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        //遍历nums1中的元素，查看对应的map
        int[] result=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            result[i]=map.getOrDefault(nums1[i],-1);
        }
        return result;
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        if(root==null){
            return new ArrayList();
        }
        ArrayList<Integer> left=inorderTraversal(root.left);
        ArrayList<Integer> right=inorderTraversal(root.right);
        ArrayList<Integer> list=new ArrayList<>();
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;
    }
    public TreeNode buildTree(){
        TreeNode a=new TreeNode(1);
        TreeNode b=new TreeNode(2);
        TreeNode c=new TreeNode(3);
        TreeNode d=new TreeNode(4);
        TreeNode e=new TreeNode(5);
        TreeNode f=new TreeNode(6);
        TreeNode g=new TreeNode(7);
        TreeNode h=new TreeNode(8);
        TreeNode i=new TreeNode(9);
        e.left=c;
        e.right=f;
        c.left=b;
        c.right=d;
        b.left=a;
        f.right=h;
        h.left=g;
        h.right=i;
        return e;
    }
    public static void main(String[] args) {
       int[] nums={2,2,3,3,3,4};
        System.out.println(thirdMax(nums));
        Solution s=new Solution();
        TreeNode root=s.buildTree();
        TreeNode head=s.increasingBST(root);
        System.out.println(head);
        int[] nums1={};
        int[] nums2={};
        System.out.println(Arrays.toString(nextGreaterElement2(nums1,nums2)));
    }
}
