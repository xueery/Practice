package Holiday12;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author:wangxue
 * @date:2020/1/31 11:23
 */
public class Main {
    public static int findUnsortedSubarray(int[] nums) {
        int[] newArr= Arrays.copyOfRange(nums,0,nums.length);
        Arrays.sort(newArr);
        int left=nums.length-1;
        int right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=newArr[i]){
                left=Math.min(i,left);
                right=Math.max(i,right);
            }
        }
        return (right-left >= 0 ? right-left+1 : 0);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int result=0;
        for(int i=0;i<tokens.length;i++){
            int second=0;
            int first=0;
            switch (tokens[i]) {
                case "+":
                    first=stack.pop();
                    second=stack.pop();
                    stack.push(first+second);
                    break;
                case "-":
                    first=stack.pop();
                    second=stack.pop();
                    stack.push(first-second);
                    break;
                case "*":
                    first=stack.pop();
                    second=stack.pop();
                    stack.push(first*second);
                    break;
                case "/":
                    first=stack.pop();
                    second=stack.pop();
                    stack.push(first/second);
                    default:
                        stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        int[] arr={1};
        System.out.println(findUnsortedSubarray(arr));
        System.out.println();
    }
}
