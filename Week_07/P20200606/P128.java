package leetcode2.P20200606;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * Created by yuchen.wu on 2020-06-06
 */

public class P128 {


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE || !set.contains(num - 1)) {
                int s = num;
                int l = 0;
                while (set.contains(s)) {
                    l++;
                    s++;
                }
                if (l > res) {
                    res = l;
                }
            }
        }
        return res;
    }

}
