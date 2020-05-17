package leetcode.P20200511;

/**
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms3 {

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int swap = nums[i];
                nums[i] = nums[swap];
                nums[swap] = swap;
            }
        }
        return -1;
    }

}
