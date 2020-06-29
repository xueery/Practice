package JavaEveryDayPractice59;

/**
 * @author:wangxue
 * @date:2020/6/22 9:29
 */
//把字符串装换为整数
public class Solution7 {
    public int StrToInt(String str) {
        if(str==null || str.length()==0)  return 0;
        int sum=0;
        for(char c:str.toCharArray()){
            if((c>='0' && c<='9' )){
                sum=sum*10+(c-48);
            }else if(c=='-' || c=='+'){
                continue;
            }else{
                return 0;
            }
        }
        if(str.charAt(0)=='-')  sum=sum*-1;
        return sum;
    }

    public static void main(String[] args) {
        Solution7 s=new Solution7();
        System.out.println(s.StrToInt("123"));
    }
}
