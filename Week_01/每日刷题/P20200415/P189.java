package leetcode.P20200415;


/**
 * 题目链接：https://leetcode-cn.com/problems/rotate-array/
 * Created by yuchen.wu on 2020-04-15
 */

public class P189 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度：O(1)
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int value = nums[next];
                nums[next] = prev;
                prev = value;
                current = next;
                count++;
            } while (start != current);
        }
    }

}
