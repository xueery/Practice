package Practice0902;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/9/2 18:42
 */
public class MergeSort {
    //先求待排序区间的中间下标
    //对左右两个小区间进行归并排序，直到小区间长度<=1
    //最后合并为一个有序数组
    public static void mergeSort(Person[] array,PersonRankComparator comparator){
        mergeSortInternal(array,0,array.length,comparator);
    }
    private static void mergeSortInternal(Person[] array, int low, int high, PersonRankComparator comparator) {
        if(low+1>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInternal(array,low,mid,comparator);
        mergeSortInternal(array,mid,high,comparator);
        merge(array,low,mid,high,comparator);
    }
    private static void merge(Person[] array, int low, int mid, int high,PersonRankComparator comparator) {
        Person[] extra=new Person[high-low];
        int iRight=mid;
        int iLeft=low;
        int iExtra=0;
        while(iLeft<mid && iRight<high){
            int r=comparator.compare(array[iLeft],array[iRight]);
            if(r<=0){
                extra[iExtra++]=array[iLeft++];
            }else{
                extra[iExtra++]=array[iRight++];
            }
        }
        while(iLeft<mid){
            extra[iExtra++]=array[iLeft++];
        }
        while(iRight<high){
            extra[iExtra++]=array[iRight++];
        }
        for(int i=0;i<high-low;i++){
            array[i+low]=extra[i];
        }
    }
    public static void mergeSort1(Person[] array){
        mergeSortInternal1(array,0,array.length);
    }
    private static void mergeSortInternal1(Person[] array, int low, int high) {
        if(low+1>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInternal1(array,low,mid);
        mergeSortInternal1(array,mid,high);
        merge1(array,low,mid,high);
    }
    private static void merge1(Person[] array, int low, int mid, int high) {
        Person[] extra=new Person[high-low];
        int iRight=mid;
        int iLeft=low;
        int iExtra=0;
        while(iLeft<mid && iRight<high){
            int r=array[iLeft].compareTo(array[iRight]);
            if(r<=0){
                extra[iExtra++]=array[iLeft++];
            }else{
                extra[iExtra++]=array[iRight++];
            }
        }
        while(iLeft<mid){
            extra[iExtra++]=array[iLeft++];
        }
        while(iRight<high){
            extra[iExtra++]=array[iRight++];
        }
        for(int i=0;i<high-low;i++){
            array[i+low]=extra[i];
        }
    }
    public static void main1(String[] args) {
        Person[] array=new Person[20];
        Random random=new Random(20190902);
        for(int i=0;i<array.length;i++){
            array[i]=new Person();
            array[i].age=random.nextInt(60);
        }
        System.out.println(Arrays.toString(array));
        mergeSort1(array);
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Person[] people=new Person[20];
        Random random=new Random();
        for(int i=0;i<people.length;i++){
            people[i]=new Person();
            people[i].age=random.nextInt(50);
            people[i].rank=random.nextInt(20);
        }
        mergeSort(people,new PersonRankComparator());
        System.out.println(Arrays.toString(people));
    }
}
