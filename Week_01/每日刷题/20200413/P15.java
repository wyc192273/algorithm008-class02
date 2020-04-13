package leetcode.P20200413;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目链接: https://leetcode-cn.com/problems/3sum/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n^2)
 * 空间复杂度: O(1)
 */

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[L] + nums[R] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (++L < R && nums[L - 1] == nums[L]) {

                    }
                    while (--R > L && nums[R + 1] == nums[R]) {

                    }
                } else if (nums[L] + nums[R] + nums[i] > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                if (nums[L] + nums[R] + nums[i] == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (++L < R && nums[L - 1] == nums[L]) {

                    }
                    while (--R > L && nums[R + 1] == nums[R]) {

                    }
                } else if (nums[L] + nums[R] + nums[i] > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return result;
    }

}
