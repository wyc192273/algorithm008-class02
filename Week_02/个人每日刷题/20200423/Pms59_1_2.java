package leetcode.P20200423;

import java.util.LinkedList;

/**
 * Created by yuchen.wu on 2020-04-23
 */

public class Pms59_1_2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> windows = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while (right < k) {
            maintainWindows(windows, nums[right++]);
        }
        while (right < nums.length) {
            int max = windows.peekFirst();
            result[left] = max;
            if (nums[left] == max) {
                windows.pollFirst();
            }
            left++;
            maintainWindows(windows, nums[right++]);
        }
        result[left] = windows.peekFirst();
        return result;
    }

    private void maintainWindows(LinkedList<Integer> windows, int num) {
        while (!windows.isEmpty() && num > windows.peekLast()) {
            windows.pollLast();
        }
        windows.offerLast(num);
    }

}
