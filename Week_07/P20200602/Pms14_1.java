package leetcode2.P20200602;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * Created by yuchen.wu on 2020-06-02
 */

public class Pms14_1 {

    public int cuttingRope(int n) {
        if(n < 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            res = 0;
            for (int j = 1; j <= i / 2; j++) {
                res = Math.max(res, dp[j] * dp[i - j]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

}
