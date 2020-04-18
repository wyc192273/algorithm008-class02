package leetcode.P20200418;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * Created by yuchen.wu on 2020-04-18
 */

public class BS2 {

    Map<Integer, Set<Integer>> map;
    int result = 0;

    public int numWays(int n, int[][] relation, int k) {
        map = new HashMap<>(n);
        for (int i = 0; i < relation.length; i++) {
            map.computeIfAbsent(relation[i][0], s -> new HashSet<>()).add(relation[i][1]);
        }
        numWaysHelp(0, n, relation, k - 1);
        return result;
    }

    public void numWaysHelp(int index, int n, int[][] relation, int k) {
        Set<Integer> relate = map.get(index);
        if (relate == null || relate.size() == 0) {
            return;
        }
        if (k == 0) {
            if (relate.contains(n - 1)) {
                result++;
            }
            return;
        }
        for (int to : relate) {
            numWaysHelp(to, n, relation, k - 1);
        }
    }

    public static void main(String[] args) {
        new BS2().numWays(5, new int[][] { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 }, { 2, 0 }, { 0, 4 } }, 3);
        String str = "\"";
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
    }

}
