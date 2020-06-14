package leetcode2.P20200613;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * Created by yuchen.wu on 2020-06-13
 */

public class P70 {


    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = n2;
            n2 = n1 + n2;
            n1 = tmp;
        }
        return n2;
    }

    public int climbStairs2(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
