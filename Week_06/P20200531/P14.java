package leetcode.P20200531;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * Created by yuchen.wu on 2020-05-31
 */

public class P14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        int i = 0;
        boolean flag = true;
        while (true) {
            Character c = null;
            for (String str : strs) {
                if (i >= str.length()) {
                    flag = false;
                    break;
                }
                if (c == null) {
                    c = str.charAt(i);
                } else {
                    if (c != str.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                break;
            }
            i++;
            res.append(c);
        }
        return res.toString();
    }

}
