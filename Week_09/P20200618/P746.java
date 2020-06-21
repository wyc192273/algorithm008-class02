package leetcode2.P20200618;

/**
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * Created by yuchen.wu on 2020-06-18
 */

public class P746 {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = cost[0];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length - 1];
    }

}
