package Holiday04;

/**
 * @author:wangxue
 * @date:2020/1/21 10:41
 */
public class Main {
    public static int lengthOfLastWord(String s) {
        s=s.trim();
        if(s.length()==0){
            return 0;
        }
        int l=s.lastIndexOf(" ");
        return s.length()-l-1;
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr=new int[m+n];
        int index=0;
        int i=0;
        int j=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                arr[index++]=nums1[i++];
            }else{
                arr[index++]=nums2[j++];
            }
        }
        while(i<m){
            arr[index++]=nums1[i++];
        }
        while(j<n){
            arr[index++]=nums2[j++];
        }
        for(int k=0;k<m+n;k++){
            nums1[k]=arr[k];
        }
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a    "));
    }
}
