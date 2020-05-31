package leetcode.P20200526;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * Created by yuchen.wu on 2020-05-26
 */

public class P287 {

    public int findDuplicate(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 1;
        int r = nums.length - 1;
        int cnt = 0;
        while (l < r) {
            int mid = l + (r - l) / 2;
            cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            //[l, mid]
            if (cnt > mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}
