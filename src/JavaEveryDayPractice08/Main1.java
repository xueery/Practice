package JavaEveryDayPractice08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/13 22:55
 */
public class Main1 {
    public static int calLastDeleteIndex(int[] num,int l){
        int deleteCount=0;
        int i=0;
        int count=0;
        while(true){
            //如果删除的数等于数组的长度，则表示删除的前一个是最后一个
            if(deleteCount==l){
                return i-1;
            }
            //如果删除到最后一个，下标重新从0开始
            if(i==l){
                i=i%l;
            }
            //如果此下标处的值不为-1，则表示此值还没有被删除，count++
            if(num[i]!=-1){
                count++;
            }
            //当count==3时，表示需要删除该数，修改此值，删除的数++，重置count=0
            if(count==3){
                deleteCount++;
                count=0;
                num[i%l]=-1;
            }
            i++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int num=scanner.nextInt();
            int[] arr=new int[num];
            int l=arr.length;
            scanner.nextLine();
            System.out.println(calLastDeleteIndex(arr,l));
        }
    }
}
