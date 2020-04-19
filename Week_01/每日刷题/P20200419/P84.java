package leetcode.P20200419;

import java.util.Stack;

/**
 * Created by yuchen.wu on 2020-04-19
 */

public class P84 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        int index = 0;
        int max = 0;
        while (index < newHeight.length) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[index]) {
                int curHeight = newHeight[stack.pop()];
                while (!stack.isEmpty() && newHeight[stack.peek()] == curHeight) {
                    stack.pop();
                }
                int curWidth = index - stack.peek() - 1;
                max = Math.max(max, curHeight * curWidth);
            }
            stack.push(index);
            index++;
        }
        return max;
    }

    public static void main(String[] args) {
        new P84().largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
    }

    /**
     * 暴力法 O(n^2)
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int left = 0;
        int max = 0;
        while (left < heights.length) {
            int min = Integer.MAX_VALUE;
            int right = left;
            for (; right < heights.length; right++) {
                min = Math.min(heights[right], min);
                max = Math.max((right - left + 1) * min, max);
            }
            left++;
        }
        return max;
    }

    /**
     * 暴力法2
     * @param heights
     * @return
     */
    public int largestRectangleArea4(int[] heights) {
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        int left = 1;
        int max = 0;
        while (left < newHeight.length - 1) {
            int lessLeft = 0;
            for (int i = left - 1; i >= 0; i--) {
                if (newHeight[i] < newHeight[left]) {
                    lessLeft = i;
                    break;
                }
            }
            int lessRight = left + 1;
            for (int i = left + 1; i < newHeight.length; i++) {
                if (newHeight[i] < newHeight[left]) {
                    lessRight = i;
                    break;
                }
            }
            max = Math.max(max, (lessRight - lessLeft - 1) * newHeight[left]);
            left++;
        }
        return max;
    }

}
