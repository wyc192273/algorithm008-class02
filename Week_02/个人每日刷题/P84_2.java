package leetcode.P20200420;

import java.util.Stack;

/**
 * Created by yuchen.wu on 2020-04-20
 */

public class P84_2 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        int max = 0;
        for (int i = 0; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[stack.peek()] > newHeights[i]) {
                int curHeight = newHeights[stack.pop()];
                while (!stack.isEmpty() && curHeight == newHeights[stack.peek()]) {
                    stack.pop();
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                max = Math.max(max, curHeight * curWidth);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        new P84_2().largestRectangleArea(new int[] {2,1,5,6,2,3});
    }

}
