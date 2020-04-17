package leetcode.P20200417;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-04-17
 */

public class P55 {

    public boolean canJump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            if (k > nums.length - 1) {
                return true;
            }
            k = Math.max(k, nums[i] + i);
        }
        return true;
    }


}
