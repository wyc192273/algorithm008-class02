package leetcode2.P20200618;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * Created by yuchen.wu on 2020-06-18
 */

public class P72 {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        if (word1.length() > word2.length()) {
            String temp  = word1;
            word1 = word2;
            word2 = temp;
        }
        int[] dp = new int[word1.length() + 1];
        int temp = 0;
        for (int i = 0; i <= word2.length(); i++) {
            temp = dp[0];
            dp[0] = i;
            for (int j = 1; j <= word1.length(); j++) {
                if (i == 0) {
                    dp[j] = j;
                    continue;
                }
                int oldTemp = dp[j];
                if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
                    dp[j] = temp;
                } else {
                    dp[j] = Math.min(temp + 1, Math.min(dp[j - 1] + 1, dp[j] +1));
                }
                temp = oldTemp;
            }
        }
        return dp[word1.length()];
    }

    public static void main(String[] args) {
        new P72().minDistance("sea", "ate");
    }

    public int minDistance2(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
