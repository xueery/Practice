package JavaEveryDayPractice03;

import java.util.Stack;

/**
 * @author:wangxue
 * @date:2019/11/8 20:37
 */
public class Solution {
    public static boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<n;i++){
            char c=A.charAt(i);
            if(c>=48 && c<=57){
                return false;
            }
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char s = stack.peek();
                        if (check(s, c)) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
            }
        }
        return true;
    }

    private static boolean check(char s, char c) {
        if((s=='('&& c==')') || (s=='['&& c==']') ||(s=='{'&& c=='}')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str="((()))";
        System.out.println(chkParenthesis(str,6));
    }
}
