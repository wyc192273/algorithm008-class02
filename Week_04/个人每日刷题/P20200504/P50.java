package leetcode.P20200504;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * Created by yuchen.wu on 2020-05-04
 */

public class P50 {

    public double myPow(double x, int n) {
        if (n < 0) {
            x =  1 / x;
            n = -n;
        }
        double ans = 1;
        double currentProduct = x;
        for (long i = n; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return ans;
    }

    public static void main(String[] args) {
        new P50().myPow(2, 10);
    }

    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x =  1 / x;
            N = -N;
        }
        return myPowHelp(x, N);
    }

    public double myPowHelp(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        return n % 2 == 0 ? myPowHelp(x, n / 2) * myPowHelp(x, n / 2) : myPowHelp(x, n / 2) * myPowHelp(x, n / 2) * x;
    }

}
