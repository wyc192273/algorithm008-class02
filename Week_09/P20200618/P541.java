package leetcode2.P20200618;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 * Created by yuchen.wu on 2020-06-18
 */

public class P541 {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int left = i;
            int right = Math.min(s.length() - 1, left + k - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new P541().reverseStr("abcdefg", 8);
    }

}
