package leetcode.P20200504;

/**
 * https://leetcode-cn.com/problems/jump-game-ii/
 * Created by yuchen.wu on 2020-05-04
 */

public class P45 {

    public int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            //找能跳的最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if( i == end){ //遇到边界，就更新边界，并且步数加一
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }


    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int result = 0;
        int left = 0;
        while (left < nums.length) {
            if (nums[left] + left >= nums.length - 1) {
                return result + 1;
            }
            // 能跳的最远的位置偏移量
            int maxJumpOffset = nums[left];
            //看当前能跳的距离内，找能跳的最远的偏移量
            for (int i = nums[left]; i > 0; i--) {
                //比对当前偏移量能跳的最远距离，是否比i位置能跳的最远距离小，如果是的话，更新偏移量
                if (nums[left + maxJumpOffset] + maxJumpOffset < nums[left + i] + i) {
                    maxJumpOffset = i;
                }
            }
            left = maxJumpOffset + left;
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        new P45().jump(new int[] { 10,9,8,7,6,5,4,3,2,1,1,0});
    }

}
