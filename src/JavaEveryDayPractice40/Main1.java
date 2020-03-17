package JavaEveryDayPractice40;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/11 12:58
 */
public class Main1 {
    public static boolean checkPalindromeStr(String s){
        int left=0;
        int right=s.length()-1;
        int count=0;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                count++;
                if(s.charAt(left+1)==s.charAt(right)){
                    left++;
                } else if(s.charAt(left)==s.charAt(right-1)){
                    right--;
                }else{
                    return false;
                }
            }else{
                left++;
                right--;
            }
        }
        if(count==1){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            if(checkPalindromeStr(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
