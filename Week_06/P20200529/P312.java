package leetcode.P20200529;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 * Created by yuchen.wu on 2020-05-29
 */

public class P312 {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        // base case 已经都被初始化为 0
        int[][] dp = new int[n + 2][n + 2];
        // 开始状态转移
        // i 应该从下往上
        for (int i = n; i >= 0; i--) {
            // j 应该从左往右
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i]*points[j]*points[k]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }

    int max = 0;

    public int maxCoins2(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        maxCoins(0, nums.length, newNums , 0);
        return max;
    }

    private void maxCoins(int i, int n, int[] nums, int res) {
        if (i == n) {
            if (res > max) {
                max = res;
            }
            return;
        }
        for (int j = 1; j < nums.length - 1; j++) {
            if (nums[j - 1] != -1 && nums[j + 2] != -1) {

            }
        }
        for (int j = 1; j < nums.length - 1; j++) {
            if (nums[j] == -1) {
                continue;
            }
            int num = nums[j];
            int tempRes = getNum(j, nums) + res;
            nums[j] = -1;
            maxCoins(i + 1, n, nums, tempRes);
            nums[j] = num;
        }
    }

    private int getNum(int i, int[] nums) {
        return nums[i] * nums[getNext(i, nums)] * nums[getPrev(i, nums)];

    }

    private int getNext(int i, int[] nums) {
        int next = i + 1;
        for (; next < nums.length; next++) {
            if (nums[next] != -1) {
                break;
            }
        }
        return next;
    }

    private int getNextNext(int i, int[] nums) {
        int next = i + 1;
        int count = 0;
        for (; next < nums.length; next++) {
            if (nums[next] != -1) {
                if (count == 1) {
                    break;
                }
                break;
            }
        }
        return next;
    }

    private int getPrev(int i, int[] nums) {
        int prev = i - 1;
        for (; prev >= 0; prev--) {
            if (nums[prev] != -1) {
                break;
            }
        }
        return prev;
    }

    public static void main(String[] args) {
        new P312().maxCoins(new int[] {3,1,5,8});
    }
}
