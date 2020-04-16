package leetcode.P20200416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/merge-intervals/
 * Created by yuchen.wu on 2020-04-16
 */

public class P56 {

    /**
     * 时间复杂度： O(nlogn)
     * 空间复杂度： O(n)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));
        List<int[]> result = new ArrayList<>();
        int idx = -1;
        for (int[] ints : intervals) {
            if (idx == -1 || ints[0] > result.get(idx)[1]) {
                result.add(ints);
                idx++;
            } else {
                result.get(idx)[1] = Math.max(result.get(idx)[1], ints[1]);
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] array = new int[][] {{2,3},{4,5},{1,10}};
        new P56().merge(array);
    }

}
