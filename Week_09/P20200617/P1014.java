package leetcode2.P20200617;

import leetcode.P20200531.P101;

/**
 * https://leetcode-cn.com/problems/best-sightseeing-pair/
 * Created by yuchen.wu on 2020-06-17
 */

public class P1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;
        int mx = A[0];
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, A[j] - j + mx);
            mx = Math.max(mx, A[j] + j);
        }
        return res;
    }

    public int maxScoreSightseeingPair2(int[] A) {
        int res = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                res = Math.max(res, A[i] + i + A[j] - j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new P1014().maxScoreSightseeingPair(new int[] { 7, 8, 8, 10 });
    }

}
