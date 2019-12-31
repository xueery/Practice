package JavaEveryDayPractice01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author:wangxue
 * @date:2019/11/3 10:29
 */
public class Solution {
    //山脉数组的峰顶索引
    public static int peakIndexInMountainArray(int[] A) {
        int maxIndex=0;
        int max=0;
        for(int i=0;i<A.length;i++){
            if(max<A[i]){
                max=A[i];
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    //有效的山脉数组
    public static boolean validMountainArray(int[] A) {
        if(A.length==1){
            return true;
        }
        int maxIndex=peakIndexInMountainArray(A);
        if(maxIndex==0 || maxIndex==A.length-1){
            return false;
        }
        boolean recordLeft=true;
        for(int i=0;i<maxIndex;i++){
            if(A[i]>=A[i+1]){
                recordLeft=false;
            }
        }
        boolean recordRight=true;
        for(int i=maxIndex;i<A.length-1;i++){
            if(A[i]<=A[i+1]){
                recordRight=false;
            }
        }
        return recordLeft && recordRight;
    }
    //数组的相对排序
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        if(arr1.length==0){
            return arr1;
        }
        if(arr2.length==0){
            Arrays.sort(arr1);
            return arr1;
        }
        Map<Integer,Integer> map=new HashMap<>();
        //将arr1中的数值存入map中
        for(int e:arr1){
            int count=map.getOrDefault(e,0);
            map.put(e,++count);
        }
        int[] ret=new int[arr1.length];
        int size=0;
        //遍历arr2，将arr2中有的数值在新数组中存入，及实现相对位置，size表示现在新数组中存入最后一个数字的位置
        for(int i=0;i<arr2.length;i++){
            int count=map.get(arr2[i]);
            for(int j=0;j<count;j++) {
                ret[size++] =arr2[i];
            }
            map.remove(arr2[i]);
        }
        //用来存放最后arr2中不存在的数
        int[] newSize=new int[ret.length-size];
        int smallSize=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int value=m.getValue();
            for(int i=0;i<value;i++){
                newSize[smallSize++]=key;
            }
        }
        //对数组进行排序
        Arrays.sort(newSize);
        //将数字存入ret数组中
        for(int i=0;i<newSize.length;i++){
            ret[i+size]=newSize[i];
        }
        return ret;
    }
    //查找第K大的数字
    public static int findKth(int[] a, int n, int K) {
        if(n==0){
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<a.length;i++){
            set.add(a[i]);
        }
        int[] arr=new int[set.size()];
        int i=0;
        for(int e:set){
            arr[i++]=e;
        }
        Arrays.sort(arr);
        return arr[arr.length-K];
    }
    public static boolean validPalindrome(String s) {
        for(int i=0;i<s.length();i++){
            String head=s.substring(0,i);
            String last=s.substring(i+1,s.length());
            String strings=head+last;
            if(palindromeString(strings)){
                return true;
            }
        }
        return false;
    }
    private static boolean palindromeString(String strings) {
        for(int i=0;i<strings.length()/2;i++){
            if(strings.charAt(i)!=strings.charAt(strings.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void reOrderArray(int [] array) {
        int left=0;
        int right=array.length-1;
        while(left<right){
            while(left<right && array[left]%2!=0){
                left++;
            }
            while(left<right && array[right]%2==0){
                right--;
            }
            swap(array,left,right);
        }
        reverseArray(array,0,left-1);
        reverseArray(array,right,array.length-1);
    }
    private static void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    private static void reverseArray(int[] array,int i,int j){
        int left=i;
        int right=j;
        while(left<right){
            swap(array,left,right);
            left--;
            right++;
        }
    }
    public static void reOrderArray1(int [] array) {
        int[] arr1=new int[array.length];
        int arrIndex1=0;
        int arrIndex2=0;
        int[] arr2=new int[array.length];
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                arr1[arrIndex1++]=array[i];
            }else{
                arr2[arrIndex2++]=array[i];
            }
        }
        for(int i=0;i<arrIndex1;i++){
            array[i]=arr1[i];
        }
        for(int i=0;i<arrIndex2;i++){
            array[arrIndex1+i]=arr2[i];
        }
    }
    //有序数组的平方
    public static int[] sortedSquares(int[] A) {
        int[] arr=new int[A.length];
        int index=0;
        for(int i=0;i<A.length;i++){
            arr[index++]=A[i]*A[i];
        }
        Arrays.sort(arr);
        return arr;
    }
    public static void main(String[] args) {
        int[] A={0,3,2,1};
        System.out.println(validMountainArray(A));
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
        int[] arr3={1,3,5,2,2};
        System.out.println(findKth(arr3,arr3.length,2));
        int[] arr4={1,2,3,4,5,6,7};
        reOrderArray1(arr4);
        System.out.println(Arrays.toString(arr4));
        int[] arr5={-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(arr5)));
    }
}
