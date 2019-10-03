package Practice0904;

import java.util.*;

/**
 * @author:wangxue
 * @date:2019/9/5 18:52
 */
public class TopKFrequent {
    public static class StringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
    //思路:  1)将每个字符串和对应的次数记录
    //       2)将每个次数和字符串对应，每个字数可能对应不止一个字符串
    //       3)将次数排序，取出前K个字符串
    public static Map<String,Integer> wordWithCount(String[] s){
        Map<String,Integer> wordwithcount=new HashMap<>();
        for(String e:s){
            int c=wordwithcount.getOrDefault(e,0);
            wordwithcount.put(e,c+1);
        }
        return wordwithcount;
    }
    public static Map<Integer,List<String>> countWithWords(Map<String,Integer> wordwithcount){
        Map<Integer,List<String>> countwithwords=new HashMap<>();
        for(Map.Entry<String,Integer> w:wordwithcount.entrySet()){
            String s=w.getKey();
            int c=w.getValue();
            List<String> wordList=countwithwords.get(c);
            if(wordList==null){
                wordList=new ArrayList<>();
                countwithwords.put(c,wordList);
            }
            wordList.add(s);
        }
        return countwithwords;
    }
    public static List<String> topKFrenquent(String[] words,int k){
        Map<String,Integer> wordTocount=wordWithCount(words);
        Map<Integer,List<String>> countToword=countWithWords(wordTocount);
        Set<Integer> keys=countToword.keySet();
        int[] array=new int[keys.size()];
        int i=0;
        for(int e:keys){
            array[i++]=e;
        }
        Arrays.sort(array);

        int index=array.length-1;
        Comparator<String> comparator=new StringComparator();
        int j=0;
        List<String> result=new ArrayList<>();
        while(j<k){
            int c=array[index--];
            List<String> wordList= countToword.get(c);
            wordList.sort(comparator);
            if(wordList.size()<=k-j){
                result.addAll(wordList);
                j+=wordList.size();
            }else{
                result.addAll(wordList.subList(0,k-j));
                j=k;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String[] s={"i","love","java","java","i","c++","java","java","java"};
        List<String> top=topKFrenquent(s,2);
        System.out.println(top);
    }
}