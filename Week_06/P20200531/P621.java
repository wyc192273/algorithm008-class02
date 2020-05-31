package leetcode.P20200531;

import java.util.Arrays;
import java.util.Map;

import leetcode.P20200526.P62;

/**
 *
 * https://leetcode-cn.com/problems/task-scheduler/
 * Created by yuchen.wu on 2020-05-31
 */

public class P621 {

    public int leastInterval(char[] tasks, int n) {
        int[] num = new int[26];
        for (int task : tasks) {
            num[task - 'A']++;
        }
        Arrays.sort(num);
        int maxVal = num[25] - 1;
        int res = maxVal * n;
        for (int i = 24; i >= 0 && num[i] > 0; i--) {
            res -= Math.min(maxVal, num[i]);
        }
        return res > 0 ? res + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        new P621().leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B'}, 2);
    }

}
