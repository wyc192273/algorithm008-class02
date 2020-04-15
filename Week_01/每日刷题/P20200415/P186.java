package leetcode.P20200415;

/**
 * 题目链接：https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/
 * Created by yuchen.wu on 2020-04-15
 */

public class P186 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度:O(1)
     * @param s
     */
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int left = 0;
        int right = 0;
        while (right < s.length) {
            right++;
            if (right == s.length || s[right] == ' ') {
                reverse(s, left, right - 1);
                right++;
                left = right;
            }
        }
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[end];
            chars[end] = chars[start];
            chars[start] = temp;
            start++;
            end--;
        }
    }
}
