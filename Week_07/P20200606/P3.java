package leetcode2.P20200606;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-06-06
 */

public class P3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        char[] chars = s.toCharArray();
        int res = 0;
        while (r <= chars.length) {
            res = Math.max(res, r - l);
            if (r == chars.length) {
                return res;
            }
            while (set.contains(chars[r])) {
                set.remove(chars[l]);
                l++;
            }
            set.add(chars[r]);
            r++;
        }
        return res;
    }

}
