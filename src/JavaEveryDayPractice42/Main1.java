package JavaEveryDayPractice42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/12 20:16
 */
public class Main1 {
    public static int[] calCoordinate(String s){
        String[] strings=s.split(";");
        List<String> list=new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            boolean flag=true;
            if(strings[i].length()<4 && strings[i].length()>0) {
                for(int j=0;j<strings[i].length();j++){
                    switch (j){
                        case 0:
                            if(!(strings[i].charAt(0)=='A' || strings[i].charAt(0)=='D'
                                    ||strings[i].charAt(0)=='W'||strings[i].charAt(0)=='S'))
                                flag=false;
                            break;
                        case 1:
                            if(!(strings[i].charAt(1)>='0' && strings[i].charAt(1)<='9'))
                                flag=false;
                            break;
                        case 2:
                            if(!(strings[i].charAt(2)>='0' && strings[i].charAt(2)<='9'))
                                flag=false;
                            break;
                    }
                }
                if(flag){
                    list.add(strings[i]);
                }
            }
        }
        //A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动
        int x=0;
        int y=0;
        for(String string:list){
            char c=string.charAt(0);
            int num=Integer.valueOf(string.substring(1));
            switch (c){
                case 'A':
                    x-=num;
                    break;
                case 'D':
                    x+=num;
                    break;
                case 'W':
                    y+=num;
                    break;
                case 'S':
                    y-=num;
                    break;
            }
        }
        int[] nums=new int[2];
        nums[0]=x;
        nums[1]=y;
        return nums;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s=scanner.nextLine();
            int[] arr=calCoordinate(s);
            System.out.println(arr[0]+","+arr[1]);
        }
    }
}
