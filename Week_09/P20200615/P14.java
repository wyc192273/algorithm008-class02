package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * Created by yuchen.wu on 2020-06-15
 */

public class P14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < res.length() && j < strs[i].length(); j++) {
                if (res.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            res = res.substring(0, j);
            if (res.equals("")) {
                return res;
            }
        }
        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        boolean flag = true;
        while (flag) {
            Character c = null;
            for (String s : strs) {
                if (s.length() == i) {
                    flag = false;
                    break;
                }
                if (c == null) {
                    c = s.charAt(i);
                } else if (c != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                i++;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


}
