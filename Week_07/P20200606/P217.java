package leetcode2.P20200606;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/contains-duplicate/
 * Created by yuchen.wu on 2020-06-06
 */

public class P217 {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }

}
