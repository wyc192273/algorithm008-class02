package leetcode.P20200423;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-04-23
 */

public class P1_3 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { i, map.get(target - nums[i]) };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

}
