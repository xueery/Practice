package JavaEveryDayPractice26;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author:wangxue
 * @date:2019/12/3 23:04
 */
public class Main1 {
    public static String exchangeMoney(double money){
        String string="人民币";
        String s=String.valueOf(money);
        String[] strings=s.split("\\.");
        HashMap<Character,Character> map=buileMap();
        int len=strings[0].length();
        for(char c:strings[0].toCharArray()){
            if(c=='1' && ((len==6 && strings[0].length()==6) || (len==2 && strings[0].length()==2))){
                string+=map.get('十');
                len--;
                continue;
            }
            if(c=='0'){
                if(string.endsWith("零")){
                    len--;
                    continue;
                }else{
                    string+=map.get('0');
                    len--;
                    continue;
                }
            }
            string+=map.get(c);
            if(len==2){
                string+=map.get('十');
            }else if(len==3){
                string+=map.get('百');
            }else if(len==4){
                string+=map.get('千');
            }else if(len==5){
                string+=map.get('万');
            }else if(len==1){
                string+=map.get('元');
            }else if(len==8){
                string+=map.get('亿');
            }else if(len==7){
                string+=map.get('百');
            }else if(len==6){
                string+=map.get('十');
            }
            len--;
        }
        int lenSmall=strings[1].length();
        for(char c:strings[1].toCharArray()){
            if(lenSmall==1 && c=='0'){
                string+="整";
                break;
            }
            string+=map.get(c);
            if(lenSmall==2){
                string+=map.get('角');
            }else{
                string+=map.get('分');
            }
            lenSmall--;
        }
        return string;
    }
    private static HashMap<Character,Character> buileMap(){
        HashMap<Character,Character> map=new HashMap<>();
        map.put('1','壹');
        map.put('2','贰');
        map.put('3','叁');
        map.put('4','肆');
        map.put('5','伍');
        map.put('6','陆');
        map.put('7','柒');
        map.put('8','捌');
        map.put('9','玖');
        map.put('十','拾');
        map.put('百','佰');
        map.put('千','仟');
        map.put('万','万');
        map.put('亿','亿');
        map.put('元','元');
        map.put('角','角');
        map.put('分','分');
        map.put('0','零');
        map.put('整','整');
        return map;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()) {
            double money = scanner.nextDouble();
            scanner.nextLine();
            System.out.println(exchangeMoney(money));
        }
    }
}
