package leetcode.P20200502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/3sum/
 * Created by yuchen.wu on 2020-05-02
 */

public class P15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[i] + nums[r] == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (++l < r && nums[l - 1] == nums[l]) {

                    }
                    while (l < --r && nums[r] == nums[r + 1]) {

                    }
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return result;
    }

}
