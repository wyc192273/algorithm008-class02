package leetcode2.P20200620;

/**
 * https://leetcode-cn.com/problems/regular-expression-matching/
 * Created by yuchen.wu on 2020-06-20
 */

public class P10 {

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (sc[i-1] == pc[j-1] || pc[j-1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc[j-1] == '*') {
                    if (sc[i-1] != pc[j - 2] && pc[j - 2] != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }


}
