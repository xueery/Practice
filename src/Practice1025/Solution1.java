package Practice1025;

import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author:wangxue
 * @date:2019/11/12 20:37
 */
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class Solution1 {
    //690：员工的重要性
    public int getImportance(List<Employee> employees, int id) {
        int count=0;
        for(Employee e:employees){
            if(e.id==id){
                count=e.importance;
                if(e.subordinates.size()!=0){
                    for(int i:e.subordinates) {
                        count=count+getImportance(employees,i);
                    }
                }
            }
        }
        return count;
    }
    //888：公平的糖果交换
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA=0;
        int sumB=0;
        for(int i:A){
            sumA+=i;
        }
        for(int i:B) {
            sumB += i;
        }
        int cal=sumA-sumB;
        for(int i=0;i<A.length;i++){
            for(int j=0;i<B.length;j++){
                if(cal>0) {
                    if (A[i] - B[j] == cal / 2) {
                        return new int[]{A[i],B[j]};
                    }
                }else{
                    if(B[j]-A[i]==Math.abs(cal)/2){
                        return new int[]{A[i],B[j]};
                    }
                }
            }
        }
        return null;
    }
    //172:阶乘后的零
    public int trailingZeroes(int n) {
        int num=factorial(n);
        int count=0;
        while(num>0){
            int a=num%10;
            if(a==0){
                count++;
            }
            num/=10;
        }
        return count;
    }

    private int factorial(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    //219：存在重复元素
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list=map.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            map.put(nums[i],list);
        }
        for(Map.Entry<Integer,List<Integer>> m:map.entrySet()){
            List<Integer> list=m.getValue();
            for(int i=0;i<list.size();i++){
                for(int j=0;j<i;j++){
                    if(list.get(i)-list.get(j)<=k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    //884:两句话中的不常见单词
    public String[] uncommonFromSentences(String A, String B) {
        List<String> list=new ArrayList<>();
        HashMap<String,Integer> mapA=new HashMap<>();
        HashMap<String,Integer> mapB=new HashMap<>();
        String[] stringA=A.split(" ");
        String[] stringB=B.split(" ");
        for(String s:stringA){
            int count=mapA.getOrDefault(s,0);
            mapA.put(s,++count);
        }
        for(String s:stringB){
            int count=mapB.getOrDefault(s,0);
            mapB.put(s,++count);
        }
        for(String s:stringA){
            if(!mapB.containsKey(s) && mapA.get(s)==1){
                list.add(s);
            }
        }
        for(String s:stringB){
            if(!mapA.containsKey(s) && mapB.get(s)==1){
                list.add(s);
            }
        }
        String[] strings=new String[list.size()];
        for(int i=0;i<list.size();i++){
            strings[i]=list.get(i);
        }
        return strings;
    }
}
