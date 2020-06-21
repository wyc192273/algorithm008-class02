package leetcode2.P20200617;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * Created by yuchen.wu on 2020-06-17
 */

public class P56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> result = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i <= intervals.length; i++) {
            if (i < intervals.length && right >= intervals[i][0]) {
                left = Math.min(left, intervals[i][0]);
                right = Math.max(right, intervals[i][1]);
            } else {
                result.add(new int[] { left, right });
                if (i < intervals.length) {
                    left = intervals[i][0];
                    right = intervals[i][1];
                }
            }
        }
        return result.toArray(new int[0][]);
    }

}
