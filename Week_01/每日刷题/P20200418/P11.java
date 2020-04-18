package leetcode.P20200418;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class P11 {


    /**
     * O(n)
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            max = Math.max(max, minHeight * (right - left + 1));
        }
        return max;
    }
    /**
     * O(n^2)
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            for (int i = left + 1; i <= right; i++) {
                max = Math.max(max, Math.min(height[left], height[i]) * (i - left));
            }
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
        new P11().maxArea2(new int[] {1,8,6,2,5,4,8,3,7});
    }

}
