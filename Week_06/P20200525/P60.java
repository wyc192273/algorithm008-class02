package leetcode.P20200525;

/**
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * Created by yuchen.wu on 2020-05-25
 */

public class P60 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[m - 1][n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                dp[m - 1][i] = 0;
            } else {
                dp[m - 1][i] = dp[m - 1][i + 1];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            if (obstacleGrid[i][n-1] == 1) {
                dp[i][n-1] = 0;
            } else {
                dp[i][n - 1] = dp[i + 1][n - 1];
            }
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
