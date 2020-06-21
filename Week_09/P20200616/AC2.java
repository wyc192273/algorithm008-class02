package leetcode2.P20200616;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.acwing.com/problem/content/2/
 * Created by yuchen.wu on 2020-06-16
 */

public class AC2 {

    public static void main2(String[] args) {
        int[] v = new int[] {0,1,2,3,4 };
        int[] w = new int[]{0,2,4,4,5 };

        int[] dp = new int[5 + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = 5; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
            }
        }
        System.out.println(dp[5]);
    }

    public static void main(String[] args) {
        int[] v = new int[] {0,1,2,3,4 };
        int[] w = new int[]{0,2,4,4,5 };


        int[][] dp = new int[4 + 1][5 + 1];
        for (int i = 1; i <= 4; i++) {
            for (int j = 5; j > 0; j--) {
                if (j - v[i] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= 5; i++) {
            res = Math.max(dp[4][i], res);
        }
        System.out.println(res);
    }

    public void getInput() {
        List<Integer> vList = new ArrayList();
        List<Integer> wList = new ArrayList();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            vList.add(Integer.parseInt(sc.next()));
            wList.add(Integer.parseInt(sc.next()));
        }
        int N = vList.get(0);
        int V = wList.get(0);
    }

}
