package leetcode.P20200509;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 *
 * Created by yuchen.wu on 2020-05-09
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
        return (int)l;
    }

    public static void main(String[] args) {
        System.out.println(new P69().mySqrt(9));
    }
}
