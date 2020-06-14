package leetcode2.P20200609;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * Created by yuchen.wu on 2020-06-09
 */

public class P231 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 1) {
            return true;
        }
        return (n & (n - 1)) == 0;
    }

}
