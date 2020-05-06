package leetcode.P20200504;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * Created by yuchen.wu on 2020-05-04
 */

public class P70 {

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int n1 = 1;
        int n2 = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = n2 + n1;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

}
