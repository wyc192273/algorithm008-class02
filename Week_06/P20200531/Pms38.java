package leetcode.P20200531;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * Created by yuchen.wu on 2020-05-31
 */

public class Pms38 {

    boolean[] used;

    public String[] permutation(String s) {
        Set<String> result = new HashSet<>();
        used = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        permutation(0, chars, new char[chars.length], result);
        return result.toArray(new String[0]);
    }

    private void permutation(int i, char[] chars, char[] temp, Set<String> result) {
        if (i == chars.length) {
            result.add(new String(temp));
            return;
        }
        for (int j = 0; j < chars.length; j++) {
            if (used[j]) {
                continue;
            }
            if (j != 0 && chars[j] == chars[j - 1] && !used[j - 1]) {
                continue;
            }
            temp[i] = chars[j];
            used[j] = true;
            permutation(i + 1, chars, temp, result);
            used[j] = false;
        }
    }
}
