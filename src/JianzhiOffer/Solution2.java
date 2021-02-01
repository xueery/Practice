package JianzhiOffer;

/**
 * @author:wangxue
 * @date:2021/2/1 20:51
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));
            }else{
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
