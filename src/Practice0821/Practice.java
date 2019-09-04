package Practice0821;

import java.util.ArrayList;

public class Practice {
    //括号匹配
    //思路：左括号入栈，右括号与左括号匹配
    public static boolean isValid(String s){
        ArrayList<Character> stack=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            switch(ch){
                case '(':
                case '[':
                case '{':
                    stack.add(ch);
                    break;
                case ')':
                case ']':
                case '}': {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char left = stack.remove(stack.size() - 1);
                    if (!match(left,ch)) {
                        return false;
                    }
                    break;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
    public static boolean match(char left,char right){
        if(left=='('&&right==')'){
            return true;
        }
        if(left=='['&&right==']'){
            return true;
        }
        if(left=='{'&&right=='}'){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s="{()}{}";
        System.out.println(isValid(s));
    }
}
