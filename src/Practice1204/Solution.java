package Practice1204;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/**
 * @author:wangxue
 * @date:2019/12/4 16:18
 */
public class Solution{
    //第三大的数
    public int thirdMax(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        int[] arr=new int[set.size()];
        int index=0;
        for(int i:set){
            arr[index++]=i;
        }
        Arrays.sort(arr);
        if(arr.length<3){
            return arr[arr.length-1];
        }
        return arr[arr.length-3];
    }
    //709转换成小写字母
    public String toLowerCase(String str) {
        String s="";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>=65 && str.charAt(i)<=90){
                int n=str.charAt(i)+32;
                s+=(char)n;
            }else{
                s+=str.charAt(i);
            }
        }
        return s;
    }
    //两数之和（不能使用+ -）
    public static int getSum(int a, int b) {
        BigInteger A=new BigInteger(String.valueOf(a));
        BigInteger B=new BigInteger(String.valueOf(b));
        int n=(A.add(B)).intValue();
        return n;
    }
    //195:第十行
    public static void printTen() throws IOException {
        FileReader fr=new FileReader("file.txt");
        BufferedReader br=new BufferedReader(fr);
        int count=0;
        while (true){
            count++;
            String s=br.readLine();
            if(count==10){
                System.out.println(s);
                break;
            }
        }
    }
    //506相对名次
    public static String[] findRelativeRanks(int[] nums) {
        String[] strings=new String[nums.length];
        int[] arr=new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr);
        int count=0;
        for(int i=arr.length-1;i>=0;i--){
            count++;
            for(int j=0;j<nums.length;j++){
                if(arr[i]==nums[j]){
                    if(count==1){
                        strings[j]="Gold Medal";
                    }else if(count==2){
                        strings[j]="Silver Medal";
                    }else if(count==3){
                        strings[j]="Bronze Medal";
                    }else{
                        strings[j]=String.valueOf(count);
                    }
                }
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        //Scanner scanner=new Scanner(System.in);
       // int a=scanner.nextInt();
        //int b=scanner.nextInt();
        //System.out.println(getSum(a,b));
        int[] arr={5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
