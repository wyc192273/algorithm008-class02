package leetcode.P20200430;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * Created by yuchen.wu on 2020-04-30
 */

public class P202 {
    public boolean isHappy(int n) {
        int inputN = n;
        int result = n;
        Set<Integer> set = new HashSet<>();

        while (result != 1) {
            n = result;
            result = 0;
            while (n != 0) {
                int num = n % 10;
                n = n / 10;
                result += (num * num);
            }
            if (set.contains(result)) {
                return false;
            }
            set.add(result);
        }
        return true;
    }

    public static void main(String[] args) {
        new P202().isHappy(15);
    }
}
