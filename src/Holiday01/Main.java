package Holiday01;

import java.util.Arrays;

/**
 * @author:wangxue
 * @date:2020/1/18 14:27
 */
public class Main {
    public static String toLowerCase(String str){
        if(str==null){
            return null;
        }
        StringBuilder s=new StringBuilder();
        for(char c:str.toCharArray()){
            if(c>='A' && c<='Z'){
                c=(char)(c+32);
                s=s.append(c);
            }else{
                s=s.append(c);
            }
        }
        return s.toString();
    }
    //旋转数组，空间复杂度为O(n)
    public static void rotate(int[] nums, int k) {
        int[] ret=Arrays.copyOf(nums,nums.length);
        for(int i=0;i<nums.length;i++){
            nums[(i+k)%nums.length]=ret[i];
        }
    }
    //旋转数组，空间复杂度为O(1)
    public static void rotate1(int[] nums,int k){
        //先整个逆序，在前k个逆序，后n-k个逆序
        //原始数组                  : 1 2 3 4 5 6 7
        //反转所有数字后             : 7 6 5 4 3 2 1
        //反转前 k 个数字后          : 5 6 7 4 3 2 1
        //反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
        k=k%nums.length;
        reveres(nums,0,nums.length-1);
        reveres(nums,0,k-1);
        reveres(nums,k,nums.length-1);
    }

    private static void reveres(int[] nums, int i, int j) {
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        System.out.println(toLowerCase(""));
        int[] nums={1,2,3,4,5,6};
        rotate1(nums,3);
        System.out.println(Arrays.toString(nums));
    }
}
