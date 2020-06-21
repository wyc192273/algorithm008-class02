package leetcode2.P20200620;

import java.util.Set;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * Created by yuchen.wu on 2020-06-20
 */

public class P771 {

    public int numJewelsInStones(String J, String S) {
        int[] count = new int[128];
        for (char c : J.toCharArray()) {
            count[c]++;
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (count[c] != 0) {
                res++;
            }
        }
        return res;
    }

}
