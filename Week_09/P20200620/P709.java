package leetcode2.P20200620;

/**
 * Created by yuchen.wu on 2020-06-20
 */

public class P709 {

    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char)(c + 'a' - 'A'));
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

}
