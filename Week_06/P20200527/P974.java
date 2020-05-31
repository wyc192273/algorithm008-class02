package leetcode.P20200527;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
 * Created by yuchen.wu on 2020-05-27
 */

public class P974 {


    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSumModK = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            preSumModK = (preSumModK + A[i]) % K;
            if(preSumModK < 0) preSumModK += K;
            if (map.containsKey(preSumModK)) {
                count += map.get(preSumModK);
            }
            int c = map.getOrDefault(preSumModK, 0) + 1;
            map.put(preSumModK, c);
        }
        return count;
    }

    public static void main(String[] args) {
        new P974().subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5);
    }
}
