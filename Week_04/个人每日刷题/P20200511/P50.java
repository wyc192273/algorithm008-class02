package leetcode.P20200511;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * Created by yuchen.wu on 2020-05-11
 */

public class P50 {

    public double myPow(double x, long n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1;
        double current = x;
        for (long i = n; i > 0; i >>= 1) {
            if (i % 2 == 1) {
                ans = ans * current;
            }
            current = current * current;
        }
        return ans;
    }

}
