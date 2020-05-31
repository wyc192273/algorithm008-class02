package leetcode.P20200526;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * Created by yuchen.wu on 2020-05-26
 */

public class P322 {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] < min) {
                    min = dp[i - coins[j]] + 1;
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        new P322().coinChange(new int[] { 186, 419, 83, 408 }, 6249);
    }

}
