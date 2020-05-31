package leetcode.P20200531;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 * Created by yuchen.wu on 2020-05-31
 */

public class Ptt1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r <= s.length()) {
            ans = Math.max(ans, r - l);
            if (r == s.length()) {
                break;
            }
            while (l < r && set.contains(chars[r])) {
                set.remove(chars[l]);
                l++;
            }
            set.add(chars[r]);
            r++;
        }
        return ans;
    }
}
