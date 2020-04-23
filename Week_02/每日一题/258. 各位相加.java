package leetcode.P20200423;

/**
 * Created by yuchen.wu on 2020-04-23
 */

public class P258 {

    public int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }
        int result = 0;
        while (num % 10 > 0 || num / 10 > 0) {
            result += num % 10;
            num = num / 10;
        }
        return addDigits(result);
    }

}
