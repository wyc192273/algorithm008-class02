package leetcode.P20200415;

/**
 * https://leetcode-cn.com/problems/plus-one/
 * Created by yuchen.wu on 2020-04-15
 */

public class P66_2 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            if(digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
