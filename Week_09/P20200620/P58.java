package leetcode2.P20200620;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 * Created by yuchen.wu on 2020-06-20
 */

public class P58 {

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int l = 0;
        int r = 0;
        int length = 0;
        while (r < s.length()) {
            if (chars[r] == ' ') {
                if (chars[l] != ' ') {
                    length = r - l;
                }
                l = r + 1;
            }
            r++;
        }
        if (chars[s.length() - 1] != ' ') {
            length = r - l;
        }
        return length;
    }

    public static void main(String[] args) {
        new P58().lengthOfLastWord("b   a   ");
    }

}
