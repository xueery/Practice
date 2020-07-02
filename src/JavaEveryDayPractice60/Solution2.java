package JavaEveryDayPractice60;

/**
 * @author:wangxue
 * @date:2020/6/24 20:47
 */
import java.util.*;
// 数据流中的中位数
public class Solution2 {
    public static ArrayList<Double> list=new ArrayList<>();
    public static void Insert(Integer num) {
        double n=num;
        if(list.size()==0){
            list.add(n);
        }else{
            int index=0;
            list.add(n);
            for(int i=list.size()-2;i>=0;i--){
                if(n<list.get(i)){
                    list.set(i+1,list.get(i));
                    index=i;
                }
            }
            list.set(index,n);
        }
    }

    public static Double GetMedian() {
        double ret=0;
        if(list.size()%2==0){
            int i=list.size()/2-1;
            ret=(list.get(i)+list.get(i+1))/2;
        }else{
            int i=list.size()/2;
            ret=list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int n=scanner.nextInt();
            Insert(n);
            System.out.println(list);
            System.out.println(GetMedian());
        }
    }
}
