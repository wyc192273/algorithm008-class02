package leetcode.P20200426;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * Created by yuchen.wu on 2020-04-26
 */

public class P75 {

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length;
        for (int i = 0; i < r;) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
                i++;
            } else if (nums[i] == 2) {
                r--;
                int temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }
    }

}
