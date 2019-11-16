package Practice1012;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/10/12 18:52
 */
public class Interivew {
    //输出一个数成为菲波那切数列最少需要多少步
    public static int minStepFibonacci(int num) {
        for (int i = 0; i < num; i++) {
            if (fibonacci(i) == num) {
                return 0;
            }
            if (fibonacci(i) > num) {
                int k = fibonacci(i - 1);
                int min = Math.min(fibonacci(i) - num, num - k);
                return min;
            }
        }
        return 0;
    }

    public static int fibonacci(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

    //计算一次需要多少不同种的材料
    public static int countMar() {
        HashSet<String> set = new HashSet();
        Scanner s = new Scanner(System.in);
        //用Ctrl+D结束输入
        while (s.hasNext()) {
            String k = s.nextLine();
            String[] m = k.split(" ");
            for (int j = 0; j < m.length; j++) {
                set.add(m[j]);
            }
        }
        return set.size();
    }

    //有效的括号
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char a : arr) {
            if (a == '[' || a == '{' || a == '(') {
                stack.push(a);
            }
            if (a == ']' || a == '}' || a == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char p = stack.pop();
                if (!check(p, a)) {
                    return false;
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean check(char p, char q) {
        if((p=='('&&q==')')||(p=='{' && q=='}') ||(p=='[' && q==']')){
            return true;
        }
        return false;
    }
    //加一
    // 输入: [1,2,3]
    //输出: [1,2,4]
    //解释: 输入数组表示数字 123
    public static int[] plusOne(int[] digits) {
        int max=digits.length-1;
        if(digits[max]<9) {
            digits[max] = digits[max] + 1;
        }else{
            digits[max]=0;
            while(max-1>=0 && digits[max-1]==9){
                digits[max-1]=0;
                max--;
            }
            if(max-1==-1){
               digits=new int[digits.length+1];
               digits[0]=1;
               return digits;
            }
            digits[max-1]=digits[max-1]+1;
        }
        return digits;
    }
    public static void main(String[] args) {
         /*
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(minStepFibonacci(n));
        */
         String s="";
        System.out.println(isValid(s));
        int[] arr={9,9,9,9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}

