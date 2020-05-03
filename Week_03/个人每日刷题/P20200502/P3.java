package leetcode.P20200502;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * Created by yuchen.wu on 2020-05-02
 */

public class P3 {


    public int lengthOfLongestSubstring(String s) {
        Set<Character> windows = new HashSet<>();
        int max = 0;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            while (windows.contains(chars[right])) {
                windows.remove(chars[left]);
                left++;
            }
            max = Math.max(max, right - left + 1);
            windows.add(chars[right]);
            right++;
        }
        return max;
    }
}
