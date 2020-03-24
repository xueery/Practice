package JavaEveryDayPractice43;

import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2020/3/13 19:47
 */
public class Main1 {
    /**
     * 加密
     * @param encryption
     * @return
     */
    public static String encryptionStr(String encryption){
        StringBuilder sb=new StringBuilder();
        for(char c:encryption.toCharArray()){
            if(c<='9' && c>='0'){
                if(c=='9') {
                    sb.append('0');
                }else{
                    sb.append((char)(c+1));
                }
            }else if(c>='A' && c<='Z'){
                if(c=='Z'){
                    sb.append('a');
                }else{
                    sb.append((char)(c+33));
                }
            }else if(c>='a' && c<='z'){
                if(c=='z'){
                    sb.append('A');
                }else{
                    sb.append((char)(c-31));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 解密
     * @param deciphering
     * @return
     */
    public static String decipheringStr(String deciphering){
        StringBuilder sb=new StringBuilder();
        for(char c:deciphering.toCharArray()){
            if(c<='9' && c>='0'){
                if(c=='0') {
                    sb.append('9');
                }else{
                    sb.append((char)(c-1));
                }
            }else if(c>='A' && c<='Z'){
                if(c=='A'){
                    sb.append('z');
                }else{
                    sb.append((char)(c+31));
                }
            }else if(c>='a' && c<='z') {
                if (c == 'a') {
                    sb.append('Z');
                } else {
                    sb.append((char) (c - 33));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String encryption=scanner.nextLine();
            String deciphering=scanner.nextLine();
            System.out.println(encryptionStr(encryption));
            System.out.println(decipheringStr(deciphering));
        }
        scanner.close();
    }
}
