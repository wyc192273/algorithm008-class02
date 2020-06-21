package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 * Created by yuchen.wu on 2020-06-15
 */

public class P188 {


    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[][] dp = new int[k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[j][1] = -prices[0];
            dp[j][0] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                int tmp1 = dp[j][1];
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);
                dp[j][0] = Math.max(dp[j][0], tmp1 + prices[i]);
            }
        }
        return dp[k][0];
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int tmp0 = dp0;
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, tmp0 - prices[i]);
        }
        return dp0;
    }

    public int maxProfit2(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (k > prices.length / 2) {
            return maxProfit(prices);
        }
        int[][][] dp = new int[prices.length][k + 1][2];
        for (int j = 0; j <= k; j++) {
            dp[0][j][1] = -prices[0];
            dp[0][j][0] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[prices.length - 1][k][0];
    }



}
