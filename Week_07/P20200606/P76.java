package leetcode2.P20200606;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * Created by yuchen.wu on 2020-06-06
 */

public class P76 {

    public String minWindow(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : tc) {
            int count = need.getOrDefault(c, 0) + 1;
            need.put(c, count);
        }
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int r = 0;
        int match = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        while (r < sc.length) {
            int count = window.getOrDefault(sc[r], 0) + 1;
            window.put(sc[r], count);
            if (window.get(sc[r]).equals(need.getOrDefault(sc[r], 0))) {
                match++;
            }
            r++;
            while (match == need.size()) {
                if (minLength > r - l) {
                    minLength = r - l;
                    minStart = l;
                }
                int ocount = window.get(sc[l]) - 1;
                window.put(sc[l], ocount);
                if (need.containsKey(sc[l]) && need.get(sc[l]) > ocount) {
                    match--;
                }
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

}
