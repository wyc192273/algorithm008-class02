package leetcode.P20200423;

/**
 * Created by yuchen.wu on 2020-04-23
 */

public class P283 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j++) {
                    nums[i] = 0;
                }
            }
        }
    }

}
