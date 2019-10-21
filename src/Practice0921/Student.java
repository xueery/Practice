package Practice0921;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author:wangxue
 * @date:2019/9/21 21:29
 */
public class Student {
    String major;
    int sex;
    Student(String major,int sex){
        this.major=major;
        this.sex=sex;
    }

    public static void main(String[] args) {
        Random r=new Random();
        Random x=new Random();
        Student[] students=new Student[1000];
        Map<String,int[]> map=new HashMap<>();
        String[] s={"物联网","网络","数学","计算机"};
        //先将专业存入map中，value存容量为2的空数组
        for(String e:s){
            map.put(e,new int[2]);
        }
        //再给students数组中放入值
        for(int i=0;i<1000;i++){
            int b=r.nextInt(4);
            int c=x.nextInt(2);
            students[i]=new Student(s[b],c);
        }
        //遍历students数组，根据专业和性别给相应的数组的下标为1或者为0的人数++
        for(Student e:students){
            map.get(e.major)[e.sex]++;
        }
        //输出map
        for(Map.Entry<String,int[]> e:map.entrySet()){
            String u=e.getKey();
            int[] a=e.getValue();
            System.out.printf("专业%s 男生人数%d 女生人数%d\n",u,a[0],a[1]);
        }
    }
}
