package JavaEveryDayPractice55;

import java.util.*;
public class Main{
    public static void sort(List<Integer> list){
        int left=0;
        int right=list.size()-1;
        while(left<right){
            while(left<right && list.get(left)%2==0){
                left++;
            }
            while(left<right && list.get(right)%2!=0){
                right--;
            }
            int temp=list.get(left);
            list.set(left,list.get(right));
            list.set(right,temp);
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        while(scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        sort(list);
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}