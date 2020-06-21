package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * Created by yuchen.wu on 2020-06-15
 */

public class P714 {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int dp00 = 0;
        int dp01 = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            int tmp1 = dp01;
            dp01 = Math.max(dp01, dp00 - prices[i] - fee);
            dp00 = Math.max(dp00, tmp1 + prices[i]);
        }
        return dp00;
    }

    public int maxProfit2(int[] prices, int fee) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[prices.length - 1][0];
    }

}
