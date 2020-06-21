package leetcode2.P20200615;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * Created by yuchen.wu on 2020-06-15
 */

public class P121 {

    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        //dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        //dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
        //dp[i][0][0] = 0

        //dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
        //dp[i][1] = Math.max(dp[i-1][1], -prices[i])
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[prices.length-1][0];
    }

}
