package leetcode2.P20200610;

/**
 * https://leetcode-cn.com/problems/counting-bits/description/
 * Created by yuchen.wu on 2020-06-10
 */

public class P338 {

    public int[] countBits(int num) {
        if (num == 0) {
            return new int[] {0};
        }
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 0) {
                result[i] = result[i >> 1] + 1;
            } else {
                result[i] = result[i - 1];
            }
        }
        return result;
    }

    public int[] countBits2(int num) {
        if (num == 0) {
            return new int[] {0};
        }
        int[] result = new int[num + 1];
        result[0] = 0;
        int next2Mi = 2;
        int now2Mi = 0;
        int i = 1;
        while (i <= num) {
            if (i < next2Mi) {
                result[i] = 1 + result[i - now2Mi];
            } else {
                now2Mi = next2Mi;
                next2Mi <<= 1;
                result[i] = 1;
            }
            i++;
        }
        return result;
    }

}
