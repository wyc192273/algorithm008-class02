package leetcode2.P20200610;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * Created by yuchen.wu on 2020-06-10
 */

public class P9 {

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0) {
            return false;
        }
        String s = Integer.toString(x);
        char[] chars = s.toCharArray();
        int r = chars.length -1;
        int l = 0;
        while (l < r) {
            if (chars[l++] != chars[r--]) {
                return false;
            }
        }
        return true;
    }

}
