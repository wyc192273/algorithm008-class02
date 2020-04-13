package leetcode.P20200413;

/**
 * 题目链接：https://leetcode-cn.com/problems/move-zeroes/
 * Created by yuchen.wu on 2020-04-13
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 *
 */

public class P283 {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j++) {
                    nums[i] = 0;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != j++) {
                nums[j-1] = nums[i];
                nums[i] = 0;
            }
        }
    }

}
