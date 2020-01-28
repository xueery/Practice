package JavaEveryDayPractice15;

import javax.security.sasl.SaslClient;
import java.util.*;

/**
 * @author:wangxue
 * @date:2019/11/21 19:17
 */
public class Main {
    public static int addAB(int A, int B) {
        /*
        List<Integer> listA=tenChangeTwo(A);
        List<Integer> listB=tenChangeTwo(B);
        int[] arr=new int[Math.max(listA.size(),listB.size())+1];
        int index=arr.length-1;
        for(int i=1;i<=Math.min(listA.size(),listB.size());i++){
            int num=listA.get(listA.size()-i)+listB.get(listB.size()-i)+arr[index];
            addArray(arr,index,num);
            index--;
        }
        int sub=Math.max(listA.size(),listB.size())-Math.min(listA.size(),listB.size());
        for(int i=sub-1;i>=0;i--){
            if(Math.max(listA.size(),listB.size())==listA.size()){
                int num=arr[index]+listA.get(i);
                addArray(arr,index,num);
                index--;
            }else{
                int num=arr[index]+listB.get(i);
                addArray(arr,index,num);
                index--;
            }
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i]*(int)Math.pow(2,arr.length-i-1);
        }
        return sum;
        */
        if(B==0)
            return A;
        int sum = A ^ B; //相加但不进位
        int jin = (A & B) << 1; //进位但不相加
        return addAB(sum, jin);
    }
    private static void addArray(int[] arr,int index,int num){
        if(num==3){
            arr[index]=1;
            arr[index-1]++;
        }else if(num==2){
            arr[index]=0;
            arr[index-1]++;
        }else {
            arr[index] = num;
        }
    }
    private static List<Integer> tenChangeTwo(int num){
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while(num>0){
            int a=num%2;
            stack.push(a);
            num/=2;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] strings=s.split(",");
        System.out.println(addAB(Integer.valueOf(strings[0]),Integer.valueOf(strings[1])));
    }
}
