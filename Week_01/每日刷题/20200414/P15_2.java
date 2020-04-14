package leetcode.P20200414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接: https://leetcode-cn.com/problems/3sum/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(1)
 */

public class P15_2 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[L] + nums[R] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[L], nums[R], nums[i]));
                    while (++L < R && nums[L - 1] == nums[L]) {
                    }
                    while (--R > L && nums[R] == nums[R + 1]) {

                    }
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }
}
