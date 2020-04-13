package leetcode.P20200413;

/**
 * 题目链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * Created by yuchen.wu on 2020-04-14
 */

public class P26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return ++j;
    }

}
