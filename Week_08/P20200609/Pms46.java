package leetcode2.P20200609;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * Created by yuchen.wu on 2020-06-09
 */

public class Pms46 {
    public int translateNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        if (chars.length < 2) {
            return 1;
        }
        int pre2 = 1;
        int pre = 1;
        for (int i = 1; i < chars.length; i++) {
            int nowNum = (chars[i] - '0');
            int sumNum = (chars[i - 1] - '0') * 10 + nowNum;
            int tempPre = pre;
            pre = sumNum < 26 && sumNum != nowNum ? pre + pre2 : pre;
            pre2 = tempPre;
        }
        return pre;
    }

    public int translateNum2(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        if (chars.length < 2) {
            return 1;
        }
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= chars.length; i++) {
            int nowNum = (chars[i - 1] - '0');
            int sumNum = (chars[i - 2] - '0') * 10 + nowNum;
            dp[i] = sumNum < 26 && sumNum != nowNum ? dp[i - 1] + dp[i - 2] : dp[i - 1];
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        System.out.println(1 ^ ~0);
        System.out.println(5 ^ (~5));
        System.out.println(~(0b111));
        System.out.println(1 ^1);
        System.out.println(7 & (~0 << 2));//111
        System.out.println(8 & -8); // 111 101
    }
}
