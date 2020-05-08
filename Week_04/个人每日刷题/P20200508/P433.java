package leetcode.P20200508;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * Created by yuchen.wu on 2020-05-08
 */

public class P433 {

    private static char[] exchange = new char[] {'A', 'C', 'G', 'T'};

    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) {
            return 0;
        }
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(end)) {
            return -1;
        }
        return minMutationHelp(0, 0, start, end, bankSet);
    }

    public int minMutationHelp(int index, int count, String start, String end, Set<String> bank) {
        if (start.equals(end)) {
            return count;
        }
        if (index >= start.length()) {
            return -1;
        }
        char[] chars = start.toCharArray();
        for (int i = 0; i < start.length(); i++) {
            for (char c : exchange) {
                if (c == chars[i]) {
                    continue;
                }
                char oldChar = chars[i];
                chars[i] = c;
                String str = new String(chars);
                if (!bank.contains(str)) {
                    chars[i] = oldChar;
                    continue;
                }
                bank.remove(str);
                int re = minMutationHelp(i == index ? index + 1 : index, count + 1, str, end, bank);
                if (re != -1) {
                    return re;
                }
                bank.add(str);
                chars[i] = oldChar;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new P433().minMutation("AACCGGTT", "AAACGGTA", new String[] { "AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA" }));
    }

}
