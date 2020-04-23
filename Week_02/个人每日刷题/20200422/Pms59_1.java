package leetcode.P20200422;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * Created by yuchen.wu on 2020-04-22
 */

public class Pms59_1 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> window = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        while (right < k) {
            maintainWindows(window, nums[right++]);
        }
        while (right <= nums.length) {
            int max = window.getFirst();
            result[left] = max;
            if (nums[left++] == max) {
                window.pollFirst();
            }
            if (right == nums.length) {
                break;
            }
            maintainWindows(window, nums[right++]);
        }
        return result;
    }

    private void maintainWindows(LinkedList<Integer> window, int num) {
        while (!window.isEmpty() && window.getLast() < num) {
            window.pollLast();
        }
        window.addLast(num);
    }
}
