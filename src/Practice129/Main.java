package Practice129;

/**
 * @author:wangxue
 * @date:2021/1/29 23:16
 */
// 最长公共前缀
class Main {
    public String longestCommonPrefix(String[] strs) {
        // 判断数组为空的情况
        if (strs.length == 0) return "";
        String sb = strs[0];
        // 设 ret 初始值为 strs[0] 是保证数组长度为1时，返回的结果为 strs[0]
        StringBuilder ret = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            ret = new StringBuilder();
            int min = Math.min(sb.length(), strs[i].length());
            for (int j = 0; j < min; j++) {
                if (sb.charAt(j) != strs[i].charAt(j)) break;
                else {
                    ret.append(sb.charAt(j));
                }
            }
            if (ret.length() != 0) {
                sb = ret.toString();
            } else {
                break;
            }
        }
        return ret.toString();
    }
}
