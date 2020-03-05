package JavaEveryDayPractice33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/2 20:44
 */
public class Main1 {
    public static String change(String s){
        String[] strings=s.split(" ");
        String[] sP=strings[0].split("\\.");
        String[] rP=strings[1].split("\\.");
        int[] shouldP=new int[sP.length];
        int[] realP=new int[rP.length];
        for(int i=0;i<3;i++){
            shouldP[i]=Integer.valueOf(sP[i]);
            realP[i]=Integer.valueOf(rP[i]);
        }
        String str=sub(shouldP,realP);
        if(str==null){
            for(int i=0;i<3;i++){
                shouldP[i]=Integer.valueOf(sP[i]);
                realP[i]=Integer.valueOf(rP[i]);
            }
            StringBuilder sb=new StringBuilder("-");
            sb.append(sub(realP,shouldP));
            str=sb.toString();
        }
        return str;
    }
    private static String sub(int[] shouldP,int[] realP){
        List<Integer> list=new ArrayList<>();
        int count=2;
        int sub;
        while(count>=0) {
            switch (count) {
                case 0:
                    sub=realP[0]-shouldP[0];
                    if(sub<0){
                        return null;
                    }
                    list.add(sub);
                    count--;
                    break;
                case 1:
                    sub = realP[1] - shouldP[1];
                    if (sub >= 0) {
                        list.add(sub);
                    }else{
                        realP[0]--;
                        list.add(realP[1]+17-shouldP[1]);
                    }
                    count--;
                    break;
                case 2:
                    sub = realP[2] - shouldP[2];
                    if (sub >= 0) {
                        list.add(sub);
                    } else {
                        realP[1]--;
                        list.add(realP[2] + 29 - shouldP[2]);
                    }
                    count--;
                    break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(list.get(i));
            if(i!=0) {
                sb.append(".");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(change(s));
        }
    }
}
