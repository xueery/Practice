package JavaEveryDayPractice54;

import java.util.*;

/**
 * @author:wangxue
 * @date:2020/4/7 14:34
 */
public class Main1 {
    public static List<Integer> reverse(Stack<Integer> stack,int n){
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(stack.pop());
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            int num=scanner.nextInt();
            stack.push(num);
        }
        List<Integer> list=reverse(stack,n);
        for(int i=0;i<n;i++){
            System.out.print(list.get(i)+" ");
        }
    }
}
