package leetcode.P20200427;

/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 * Created by yuchen.wu on 2020-04-27
 */

public class Pms1709 {

    public int getKthMagicNumber(int k) {
        int P3 = 0;
        int P5 = 0;
        int P7 = 0;
        int[] DP = new int[k];
        DP[0] = 1;
        for (int i = 1; i < k; i++) {
            DP[i] = Math.min(DP[P3] * 3, Math.min(5 * DP[P5], 7 * DP[P7]));
            if(DP[i] == DP[P3] * 3) P3++;
            if(DP[i] == 5 * DP[P5]) P5++;
            if(DP[i] ==  7 * DP[P7]) P7++;
        }
        return DP[k - 1];
    }

}
