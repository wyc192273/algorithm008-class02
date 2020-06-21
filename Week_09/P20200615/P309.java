package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Created by yuchen.wu on 2020-06-15
 */

public class P309 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp00 = 0;
        int dp01 = Integer.MIN_VALUE;
        int dp00_pre = 0;

        for (int i = 0; i < prices.length; i++) {
            int tmp1 = dp00;
            dp00 = Math.max(dp00, dp01 + prices[i]);
            dp01 = Math.max(dp01, dp00_pre - prices[i]);
            dp00_pre = tmp1;
        }
        return dp00;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i - 2 >= 0) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][0];
    }

}
