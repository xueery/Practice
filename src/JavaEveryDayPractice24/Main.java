package JavaEveryDayPractice24;

import InternetProgrammer.InetAddressDemo;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/11/30 21:57
 */
public class Main {
    public static void sortNumber(List<Integer> list){
        int A1=0;
        List<Integer> A2=new ArrayList<>();
        int A3=0;
        List<Integer> A4=new ArrayList<>();
        int A5=0;
        for(int n:list){
            if(n%5==0){
                if(n%2==0){
                    A1+=n;
                }
            }else if(n%5==1){
                A2.add(n);
            }else if(n%5==2){
                A3++;
            }else if(n%5==3){
                A4.add(n);
            }else{
                if(A5<n){
                    A5=n;
                }
            }
        }
        int j=1;
        int sumA2=0;
        for(int i:A2){
            sumA2+=(j*i);
            j*=-1;
        }
        double aveA4=0;
        double sumA4=0.0;
        for(int i:A4){
            sumA4+=i;
        }
        aveA4=sumA4/A4.size();
        if(A1==0){
            System.out.print("N ");
        }else{
            System.out.print(A1+" ");
        }
        if(A2.size()==0){
            System.out.print("N ");
        }else{
            System.out.print(sumA2+" ");
        }
        if(A3==0){
            System.out.print("N ");
        }else{
            System.out.print(A3+" ");
        }
        if(A4.size()==0){
            System.out.print("N ");
        }else{
            System.out.print(String.format("%.1f ",aveA4));
        }
        if(A5==0){
            System.out.print("N ");
        }else{
            System.out.print(A5+" ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int n=scanner.nextInt();
        for(int i=0;i<n;i++){
            list.add(scanner.nextInt());
        }
        sortNumber(list);
    }
}
