package leetcode.P20200413;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：https://leetcode-cn.com/problems/two-sum/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */

public class P1 {

    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
