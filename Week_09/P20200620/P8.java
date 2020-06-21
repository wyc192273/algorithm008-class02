package leetcode2.P20200620;

import jnr.ffi.annotations.In;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * Created by yuchen.wu on 2020-06-20
 */

public class P8 {

    public int myAtoi(String str) {
        int index = 0, sign = 1, total = 0;
        if (str.length() == 0) {
            return 0;
        }
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if (index >= str.length()) {
            return 0;
        }
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < str.length()) {
            int digt = str.charAt(index) - '0';
            if (digt < 0 || digt > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digt) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digt;
            index++;
        }
        return sign * total;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        new P8().myAtoi("2147483648");
    }

}
