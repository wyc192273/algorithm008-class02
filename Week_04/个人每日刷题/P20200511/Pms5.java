package leetcode.P20200511;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms5 {
    public String replaceSpace(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    public String replaceSpace2(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                count++;
            }
        }
        if (count == 0) {
            return s;
        }
        char[] chars = new char[s.length() + 2 * count];
        int p1 = s.length() - 1;
        int p2 = chars.length - 1;
        while (p1 >= 0) {
            if (s.charAt(p1) != ' ') {
                chars[p2--] = s.charAt(p1);
            } else {
                chars[p2--] = '0';
                chars[p2--] = '2';
                chars[p2--] = '%';
            }
            p1--;
        }
        return new String(chars);
    }
}
