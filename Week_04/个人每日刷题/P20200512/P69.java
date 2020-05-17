package leetcode.P20200512;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 * Created by yuchen.wu on 2020-05-12
 */

public class P69 {

    public int mySqrt(int x) {
        long l = 0, r = x / 2 + 1;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int)r;
    }

    public int mySqrt2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

}
