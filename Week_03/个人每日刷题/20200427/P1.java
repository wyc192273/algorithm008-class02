package leetcode.P20200427;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * Created by yuchen.wu on 2020-04-27
 */

public class P1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[] { index, i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


}
