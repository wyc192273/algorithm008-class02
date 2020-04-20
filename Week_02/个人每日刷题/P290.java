package leetcode.P20200420;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-04-20
 */

public class P290 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> map = new HashMap<>();
        char[] charCount = new char[26];
        int left = 0;
        int index = 0;
        while (left < str.length() && index < pattern.length()) {
            int right = left;
            StringBuilder word = new StringBuilder();
            while (right < str.length() && str.charAt(right) != ' ') {
                word.append(str.charAt(right));
                right++;
            }
            Character mapChar = map.get(word.toString());
            //如果发现word对应的char存在，但是不与对应位置的char字符相等，则返回false
            //例如 ab str str
            if (mapChar != null && mapChar != pattern.charAt(index)) {
                return false;
            }
            //如果发现word没有对应的char存在，并且对应索引位置的字符已经存在与之匹配的字符串，则返回false
            // 比如 "aa" "str b"
            if (mapChar == null && charCount[pattern.charAt(index)-'a'] > 0) {
                return false;
            }
            //将word对应的字符放入到map中，并累加charCount的数量
            if (mapChar == null) {
                map.put(word.toString(), pattern.charAt(index));
            }
            charCount[pattern.charAt(index) - 'a']++;
            index++;
            right++;
            left = right;
        }
        //left < str.length() 是 pattern的字符个数小于 str的字符串的个数
        // index != pattern.length() 是 str的字符串个数 小于 pattern的字符时
        if (left < str.length() || index != pattern.length()) {
            return false;
        }
        return true;
    }

}
