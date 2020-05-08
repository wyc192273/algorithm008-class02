package leetcode.P20200508;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * Created by yuchen.wu on 2020-05-08
 */

public class P455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length - 1;
        int si = s.length - 1;
        while (si >= 0 && gi >= 0) {
            if (g[gi] <= s[si]) {
                si--;
            }
            gi--;
        }
        return s.length - si;
    }

}
