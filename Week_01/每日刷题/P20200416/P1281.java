package leetcode.P20200416;

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Created by yuchen.wu on 2020-04-16
 */

public class P1281 {

    /**
     * 时间复杂度: O(logn)
     * 空间复杂度：O(logn)
     */
    public int subtractProductAndSum(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int sum = 0;
        int product = 1;
        for (char c : chars) {
            sum += c - '0';
            product *= c - '0';
        }
        return product - sum;
    }

    /**
     * 时间复杂度: O(logn)
     * 空间复杂度：O(1)
     */
    public int subtractProductAndSum2(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            product *= num;
            n = n / 10;
        }
        return product - sum;
    }

}
