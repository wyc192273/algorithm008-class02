package leetcode.P20200509;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * Created by yuchen.wu on 2020-05-09
 */

public class P433 {

    char[] swap = new char[] {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = Arrays.stream(bank).collect(Collectors.toSet());
        if (start.equals(end)) {
            return 0;
        }
        if (!set.contains(end)) {
            return -1;
        }
        return minMutation(0, start, end, set);
    }

    private int minMutation(int result, String start, String end, Set<String> bank) {
        if (start.equals(end)) {
            return result;
        }
        if (bank.isEmpty()) {
            return -1;
        }
        char[] chars = start.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (char e : swap) {
                if (chars[i] == e) {
                    continue;
                }
                char oldC = chars[i];
                chars[i] = e;
                String str = new String(chars);
                if (!bank.contains(str)) {
                    chars[i] = oldC;
                    continue;
                }
                bank.remove(str);
                int re = minMutation(result + 1, str, end, bank);
                if (re != -1) {
                    return re;
                }
                bank.add(str);
                chars[i] = oldC;
            }
        }
        return -1;
    }

}
