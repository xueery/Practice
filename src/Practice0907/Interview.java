package Practice0907;


import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/11 16:07
 */
public class Interview {
    private static List<String> checkCommonWord(String[] string) {
        List<Map<Character,Integer>> list=new ArrayList<>();
        //将字符串都存入顺序表中
        for(String s:string){
            Map<Character,Integer> map=new HashMap<>();
            for(Character c:s.toCharArray()){
               int r=map.getOrDefault(c,0);
               map.put(c,r+1);
            }
            list.add(map);
        }
        List<String> result=new ArrayList<>();
        //遍历第一个Map，和其他的map进行比较
        for(Map.Entry<Character,Integer> c:list.get(0).entrySet()){
            char r=c.getKey();
            boolean count=true;
            for(int i=1;i<string.length;i++){
                if(!list.get(i).containsKey(r)){
                    count=false;
                    break;
                }
            }
            if(count==true){
                int min=c.getValue();
                for(int i=1;i<string.length;i++){
                    if(min>list.get(i).get(r)){
                        min=list.get(i).get(r);
                    }
                }
                for(int i=0;i<min;i++){
                    result.add(String.valueOf(c.getKey()));
                }
            }
        }
        return result;
    }
    public static List<String> checkCommonWords(String[] string){
        List<int[]> list=new ArrayList<>();
        for(String s:string){
            int[] array=new int[26];
            for(Character c:s.toCharArray()){
                int index=c-'a';
                array[index]++;
            }
            list.add(array);
        }
        int[] rString=new int[26];
        for(int i=0;i<26;i++){
            int n=Integer.MAX_VALUE;
            for(int[] a:list){
                n=Math.min(n,a[i]);
            }
            rString[i]=n;
        }
        List<String> result=new ArrayList<>();
        for(int i=0;i<26;i++){
            for(int j=0;j<rString[i];j++){
                result.add(String.valueOf((char)('a'+i)));
            }
        }
        return result;
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        int i=0;
        while(i<nums.length-2){
            int k=nums.length-1;
            int j=i+1;
            while(j<k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    list.add(l);
                    while(j<k && nums[j]==nums[j+1]){
                        j++;
                    }
                    j++;
                    while(j<k && nums[k]==nums[k-1]){
                        k--;
                    }
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            while(i<nums.length-2 && nums[i]==nums[i+1]){
                i++;
            }
            i++;
        }
        return list;
    }
    public static void main(String[] args) {
        String[] string = {"hello", "errllor", "yellow"};
        System.out.println(checkCommonWords(string));
        int[] nums={-2,0,1,1,2,0,0,0,0};
        System.out.println(threeSum(nums));
    }
}