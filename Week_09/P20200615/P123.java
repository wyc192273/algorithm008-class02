package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Created by yuchen.wu on 2020-06-15
 */

public class P123 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp10 = 0;
        int dp11 = Integer.MIN_VALUE;
        int dp20 = 0;
        int dp21 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, dp10 - prices[i]);
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, -prices[i]);
        }
        return dp20;
    }

    public int maxProfit3(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp10 = 0;
        int dp11 = -prices[0];
        int dp20 = Integer.MIN_VALUE;
        int dp21 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp20 = Math.max(dp20, dp21 + prices[i]);
            dp21 = Math.max(dp21, dp10 - prices[i]);
            dp10 = Math.max(dp10, dp11 + prices[i]);
            dp11 = Math.max(dp11, -prices[i]);
        }
        return Math.max(dp20, dp10);
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        long[][][] dp = new long[prices.length][3][2];
        //dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        //dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
        //dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
        //dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
        dp[0][1][0] = Integer.MIN_VALUE;
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][0] =
                    Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] =
                    Math.max(dp[i-1][1][1], -prices[i]);
            dp[i][2][0] =
                    Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i]);
            dp[i][2][1] =
                    Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i]);
        }
        int res = (int) Math.max(dp[prices.length - 1][2][0], dp[prices.length - 1][1][0]);
        return res < 0 ? 0 : res;
    }

    public static void main(String[] args) {
        System.out.println(new P123().maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
    }

}
