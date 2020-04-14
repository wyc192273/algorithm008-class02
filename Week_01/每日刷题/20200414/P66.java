package leetcode.P20200414;

/**
 * 题目链接：https://leetcode-cn.com/problems/plus-one/
 *
 * Created by yuchen.wu on 2020-04-14
 */

public class P66 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = (digits[i] + carry);
            digits[i] = num % 10;
            carry = num / 10;
        }
        if (carry != 0) {
            int[] newArray = new int[digits.length + 1];
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            newArray[0] = 1;
            return newArray;
        }
        return digits;
    }

}
