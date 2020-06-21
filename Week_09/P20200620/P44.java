package leetcode2.P20200620;

/**
 * https://leetcode-cn.com/problems/wildcard-matching/
 * Created by yuchen.wu on 2020-06-20
 */

public class P44 {

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i ++) {
            if (p.charAt(i) == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        new P44().isMatch("ho", "**ho");
    }

}
