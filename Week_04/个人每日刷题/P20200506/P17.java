package leetcode.P20200506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Created by yuchen.wu on 2020-05-06
 */

public class P17 {

    private static final Map<Character, List<Character>> map = new HashMap<>();

    static {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        char[] chars = digits.toCharArray();
        buildStr(result, "", chars, 0);
        return result;
    }

    private void buildStr(List<String> result, String str, char[] chars, int index) {
        if (index >= chars.length) {
            result.add(str);
            return;
        }
        for (Character c : map.get(chars[index])) {
            buildStr(result, str + c, chars, index + 1);
        }
    }

}
