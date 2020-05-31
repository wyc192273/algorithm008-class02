package leetcode.P20200525;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * Created by yuchen.wu on 2020-05-25
 */

public class P198 {

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prevDp0 = dp0;
            dp0 = Math.max(dp0, dp1);
            dp1 = prevDp0 + nums[i];
        }
        return Math.max(dp0, dp1);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length];
    }

    public int rob3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

}
