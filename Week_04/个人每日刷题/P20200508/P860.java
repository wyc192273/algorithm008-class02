package leetcode.P20200508;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * Created by yuchen.wu on 2020-05-08
 */

public class P860 {

    public boolean lemonadeChange(int[] bills) {
        int fiveBills = 0;
        int tenBills = 0;
        for (int b : bills) {
            if (b == 5) {
                fiveBills++;
                continue;
            }
            if (b == 10) {
                tenBills++;
                fiveBills--;
            } else {
                if (tenBills > 0) {
                    tenBills--;
                    fiveBills--;
                } else {
                    fiveBills -= 3;
                }
            }
            if (tenBills < 0 || fiveBills < 0) {
                return false;
            }
        }
        return true;
    }

}
