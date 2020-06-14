package leetcode2.P20200609;

/**
 * https://leetcode-cn.com/problems/reverse-bits/
 * Created by yuchen.wu on 2020-06-09
 */

public class P190 {

    public int reverseBits(int n) {
        int res = 0;
        for (int bitSize = 31; n != 0; n >>>= 1, bitSize--) {
            res |= (n & 1) << bitSize;
        }
        return res;
    }
}
