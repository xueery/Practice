package JavaEveryDayPractice57;

/**
 * @author:wangxue
 * @date:2020/5/29 9:09
 */
import java.util.ArrayList;
public class Test {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list=new ArrayList<>();
        int i=0;
        int j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
                if(list.size()==0){
                    list.add(array[i]);
                    list.add(array[j]);
                }else{
                    if(array[i]*array[j]<list.get(0)*list.get(1)){
                        list.remove(0);
                        list.remove(1);
                        list.add(array[i]);
                        list.add(array[j]);
                    }
                }
                i++;
                j--;
            }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array={1,2,4,7,11,15};
        System.out.println(FindNumbersWithSum(array,15));
    }
}
