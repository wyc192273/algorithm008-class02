package leetcode.P20200423;

/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 * Created by yuchen.wu on 2020-04-21
 */

public class Pms1709 {

    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[] DP = new int[k];
        DP[0] = 1;
        for (int i = 1; i < k; i++) {
            DP[i] = Math.min(DP[p3] * 3, Math.min(DP[p5] * 5, DP[p7] * 7));
            if(DP[i] == DP[p3] * 3) p3++;
            if(DP[i] == DP[p5] * 5) p5++;
            if(DP[i] == DP[p7] * 7) p7++;
        }
        return DP[k - 1];
    }


}
