package leetcode.P20200423;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-04-23
 */

public class P49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            map.computeIfAbsent(s, i -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[] chars = str.toCharArray();
            for (char c : chars) {
                count[c-'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                key.append(count[i] + "#");
            }
            map.computeIfAbsent(key.toString(), i -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
