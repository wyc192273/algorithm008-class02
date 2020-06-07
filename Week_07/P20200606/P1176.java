package leetcode2.P20200606;

/**
 * https://leetcode-cn.com/problems/diet-plan-performance/
 * Created by yuchen.wu on 2020-06-06
 */

public class P1176 {

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int l = 0;
        int r = 0;
        int cost = 0;
        int res = 0;
        while (r <= calories.length) {
            if (r >= k) {
                if (cost < lower) {
                    res--;
                } else if (cost > upper) {
                    res++;
                }
                cost = cost - calories[l++];
            }
            if (r == calories.length) {
                return res;
            }
            cost += calories[r];
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        new P1176().dietPlanPerformance(new int[] { 1, 2, 3, 4, 5 }, 1, 3, 3);
    }

}
