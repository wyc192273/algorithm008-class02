package leetcode.P20200530;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * Created by yuchen.wu on 2020-05-30
 */

public class P300 {


    public int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i]  = Math.max(dp[i], dp[j] + 1);
                    if (res < dp[i]) {
                        res = dp[i];
                    }
                }
            }

        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,1,7,101,18};
        System.out.println(new P300().lengthOfLIS2(nums));
    }

}
