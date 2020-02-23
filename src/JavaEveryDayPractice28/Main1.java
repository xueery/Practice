package JavaEveryDayPractice28;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/5 22:50
 */
public class Main1 {
    //将IP地址转为长整型
    public static long exchangeLong(String s){
        //对IP地址进行分割
        String[] strings=s.split("\\.");
        String string="";
        for(String s1:strings){
            //将分割的字符串都转为整型
            int n=Integer.valueOf(s1);
            //将十进制数转换成二进制
            String string1=Integer.toBinaryString(n);
            String string2="";
            //如果二进制数不够八位，用字符0补全成八位
            if(string1.length()<8 &&string1.length()>0){
                for(int i=0;i<8-string1.length();i++){
                    string2+="0";
                }
            }
            //string2表示每一被分割的数的8位二进制数
            string2+=string1;
            //将字符串分割的8位二进制数加入字符串string
            string+=string2;
        }
        //将二进制的字符串string转换为十进制的长整型
        long number=Long.parseLong(string,2);
        return number;
    }
    //将长整型转为IP地址
    public static String exchangeIP(String IP){
        //将读入的长字符串转为long类型
        Long ip=Long.parseLong(IP);
        //将long类型的数转为二进制字符串类型
        String s=Long.toBinaryString(ip);
        int length=0;
        String string="";
        //确定字符串共有几位地址
        if(s.length()%8!=0) {
            length = s.length() / 8 + 1;
            for(int i=0;i<8*length-s.length();i++){
                string+="0";
            }
        }else{
            length=s.length()/8;
        }
        //string表示共length长度的8位二进制数
        string+=s;
        String[] strings=new String[length];
        for(int i=0;i<length;i++){
            //对字符串进行分割，以8位为分割单元
            strings[i]=string.substring(i*8,(i*8)+8);
            //System.out.println(strings[i]);
        }
        string="";
        for(int i=0;i<strings.length;i++){
            //将二进制的字符串转换为整型
            int n = Integer.parseInt(strings[i], 2);
            //将整型数字转换为字符串
            String s1=String.valueOf(n);
            //如果不是最后一个字符串，则加入"."进行分割
            if(i!=strings.length-1) {
                string+=(s1+".");
            }else{
                string+=s1;
            }
        }
        //返回IP地址
        return string;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(exchangeLong(s));
            String ip = scanner.nextLine();
            System.out.println(exchangeIP(ip));
        }
    }
}
