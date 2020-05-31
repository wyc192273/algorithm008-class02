package leetcode.P20200530;

import leetcode.P20200409.P22;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 * Created by yuchen.wu on 2020-05-30
 */

public class P221 {

    //从右下角向左上方计算
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n + 1];
        int maxLength = 0;
        //从下到上，从右到左计算
        for (int i = m - 1; i >= 0; i--) {
            //为了保留上次右下角的值， 由于j 是下方的值 j+1是右方的值，所以需要保存右下角的值
            int southEast = 0;
            for (int j = n - 1; j >= 0; j--) {
                //下次计算的右下角的值实际上是当前的j的值
                int temp = dp[j];
                if (matrix[i][j] == '1') {
                    dp[j] = Math.min(southEast, Math.min(dp[j], dp[j + 1])) + 1;
                    if (maxLength < dp[j]) {
                        maxLength = dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
                //替换右下角的值为 当前位置计算前的值
                southEast = temp;
            }
        }
        return maxLength * maxLength;
    }

    public int maximalSquare2(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLength = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                    }
                }
            }
        }
        return maxLength * maxLength;
    }

    public static void main(String[] args) {
        new P221().maximalSquare(new char[][] { { '1', '1', '1', '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '0', '0', '0' }, { '0', '1', '1', '1', '1', '0', '0', '0' } });

    }
}
