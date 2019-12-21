package Practice1210;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/15 22:01
 */
public class Main9 {
    public static int maxInserestValue(int[] inserest,int[] sober,int n,int k){
        int max=0;
        int maxSober=0;
        for(int i=0;i<n;i++){
            if(sober[i]==1){
                max+=inserest[i];
            }else{
                int sum=0;
                for(int j=0;j<k;j++){
                    if(j+i<n && sober[j+i]==0){
                        sum+=inserest[j+i];
                    }else if(j+i>=n){
                        break;
                    }
                }
                if(maxSober<sum){
                    maxSober=sum;
                }
            }
        }
        return max+maxSober;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            scanner.nextLine();
            int[] inserest=new int[n];
            int[] sober=new int[n];
            for(int i=0;i<n;i++){
                inserest[i]=scanner.nextInt();
            }
            scanner.nextLine();
            for(int i=0;i<n;i++){
                sober[i]=scanner.nextInt();
            }
            scanner.nextLine();
            System.out.println(maxInserestValue(inserest,sober,n,k));
        }
    }
}
