package leetcode2.P20200620;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * Created by yuchen.wu on 2020-06-20
 */

public class P387 {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int index = 0;
        for (char c : s.toCharArray()) {
            if (count[c-'a'] == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }

}
