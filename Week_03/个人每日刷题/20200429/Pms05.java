package leetcode.P20200429;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * Created by yuchen.wu on 2020-04-29
 */

public class Pms05 {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
