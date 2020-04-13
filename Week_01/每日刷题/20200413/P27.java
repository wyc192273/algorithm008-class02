package leetcode.P20200413;

/**
 * 题目链接: https://leetcode-cn.com/problems/remove-element/submissions/
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * Created by yuchen.wu on 2020-04-14
 */

public class P27 {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

}
