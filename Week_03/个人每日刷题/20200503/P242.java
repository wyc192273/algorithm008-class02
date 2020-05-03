package leetcode.P20200503;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-anagram/description/
 * Created by yuchen.wu on 2020-05-03
 */

public class P242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] needs = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            needs[c - 'a']++;
        }
        chars = t.toCharArray();
        for (char c : chars) {
            if (needs[c - 'a'] == 0) {
                return false;
            }
            needs[c - 'a']--;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }
        chars = t.toCharArray();
        for (char c : chars) {
            Integer count = map.get(c);
            if (count == null || count == 0) {
                return false;
            }
            map.put(c, --count);
        }
        return true;
    }

}
