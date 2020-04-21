package leetcode.P20200420;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuchen.wu on 2020-04-20
 */

public class P299 {

    /**
     * 时间复杂度: O(n+k)
     * 空间复杂度: O(1)
     */
    public String getHint(String secret, String guess) {
        int[] chaCount = new int[10];
        int A = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
                continue;
            }
            //相当于目标的字符串未完全匹配，数字的个数
            chaCount[secret.charAt(i) - '0']++;
            //相当于猜测的字符串的数字将 字符个数计数数组对应的数字减掉
            chaCount[guess.charAt(i) - '0']--;
        }
        //secret中没有被匹配的数字个数，这个个数实际上就相当于是现在chaCount中为正数的总和
        int notMatchCount = 0;
        //经过上面一次循环,chaCount中数字的个数，
        // 可能为负，则相当于secret中的数字个数比guess中对应的数字个数少
        // 可能为正，相当于secret中的数字比guess中的对应的数字个数多
        // 可能为零，相当于secret中的数字和guess中的对应的数字个数正好相等
        for (int i = 0; i < 10; i++) {
            if (chaCount[i] > 0) {
                notMatchCount += chaCount[i];
            }
        }
        //从secret中，排除掉完全匹配的字符个数，在排除掉没有被匹配的字符个数，
        // 剩下的就相当于是guess中字符匹配了，但是没有完全匹配的数字个数
        //比如 secret = "1123", guess = "0111"  A = 1, notMatchCount=2,那么B=1
        int B = secret.length() - notMatchCount - A;
        return A + "A" + B + "B";
    }

    /**
     *  时间复杂度： O(3n)
     *  空间复杂度: O(1)
     *  先计算secret中每个数字的数量，将完全匹配的数字数量去掉
     *  剩下的在看不完全匹配的 数字数量，同时维护count的个数
     *  缺点：多次循环，由于没法在一次循环中确定是 A 还是 B，所以需要一次循环先排除掉A的，然后才能再计算B的
     */
    public String getHint2(String secret, String guess) {
        int[] chaCount = new int[10];
        char[] secretChars = secret.toCharArray();
        for (char c : secretChars) {
            chaCount[c - '0']++;
        }
        char[] guessChars = guess.toCharArray();
        int A = 0;
        int B = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secretChars[i] == guessChars[i]) {
                A++;
                chaCount[secretChars[i] - '0']--;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secretChars[i] != guessChars[i] && chaCount[guessChars[i] - '0'] > 0) {
                B++;
                chaCount[guessChars[i] - '0']--;
            }
        }
        return A + "A" + B + "B";
    }

}
