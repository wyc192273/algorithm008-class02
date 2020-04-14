package leetcode.P20200414;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目链接：https://leetcode-cn.com/problems/two-sum/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 */

public class P1_2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) {
                return new int[] { index, i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
