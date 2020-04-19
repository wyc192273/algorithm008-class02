package leetcode.P20200419;

/**
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * Created by yuchen.wu on 2020-04-19
 */

public class Pms50 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public char firstUniqChar(String s) {
        int[] chars = new int[26];
        char[] sc = s.toCharArray();
        for (char c : sc) {
            chars[c - 'a']++;
        }
        for (char c : sc) {
            if (chars[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

}
