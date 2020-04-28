package leetcode.P20200427;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/3sum/
 * Created by yuchen.wu on 2020-04-27
 */

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while (++left < right && nums[left - 1] == nums[left]) {

                    }
                    while (left < --right && nums[right] == nums[right + 1]) {

                    }
                } else if(sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
