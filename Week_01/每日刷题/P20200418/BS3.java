package leetcode.P20200418;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * https://leetcode-cn.com/problems/ju-qing-hong-fa-shi-jian/
 * Created by yuchen.wu on 2020-04-18
 */

public class BS3 {

    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[] result = new int[requirements.length];
        Arrays.fill(result, -1);
        int[] att0 = new int[increase.length + 1];
        int[] att1 = new int[increase.length + 1];
        int[] att2 = new int[increase.length + 1];
        for (int i = 0; i < increase.length; i++) {
            att0[i + 1] = att0[i] + increase[i][0];
            att1[i + 1] = att1[i] + increase[i][1];
            att2[i + 1] = att2[i] + increase[i][2];
        }

        for (int i = 0; i < requirements.length; i++) {
            int day_0 = binarySearchFirstOrLarge(att0, requirements[i][0]);
            int day_1 = binarySearchFirstOrLarge(att1, requirements[i][1]);
            int day_2 = binarySearchFirstOrLarge(att2, requirements[i][2]);
            if (day_0 == -1 || day_1 == -1 || day_2 == -1) {
                continue;
            }
            result[i] = Math.max(day_0, Math.max(day_1, day_2));
        }
        return result;
    }

    private int binarySearchFirstOrLarge(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (array[r] >= target) {
            return r;
        }
        return -1;
    }

    SortedSet<Map.Entry<Integer, int[]>> set ;
    Map<Integer, Integer> setResult;

    public int[] getTriggerTime2(int[][] increase, int[][] requirements) {
        TreeMap<Integer, int[]> map = new TreeMap<>();
        setResult = new HashMap<>(requirements.length);
        for (int i = 0; i < requirements.length; i++) {
            map.put(i, requirements[i]);
            setResult.put(i, -1);
        }
        set = entriesSortedByValues(map);
        int C = 0;
        int R = 0;
        int H = 0;
        int[] result = new int[requirements.length];
        int day = 0;
        finishReq(0, C, R, H);
        for (int i = 0; i < increase.length; i++) {
            if (set.size() == 0) {
                break;
            }
            day++;
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            finishReq(day, C, R, H);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = setResult.get(i);
        }
        return result;
    }

    private void finishReq(int day, int C, int R, int H) {
        List<Map.Entry<Integer, int[]>> removeInt = new ArrayList<>();
        for (Map.Entry<Integer, int[]> entry : set) {
            int[] r = entry.getValue();
            if (C >= r[0] && R >= r[1] && H >= r[2]) {
                removeInt.add(entry);
                setResult.put(entry.getKey(), day);
            }
        }
        for (Map.Entry<Integer, int[]> entry : removeInt) {
            set.remove(entry);
        }
    }

     SortedSet<Map.Entry<Integer, int[]>> entriesSortedByValues(Map<Integer, int[]> map) {
        SortedSet<Map.Entry<Integer, int[]>> sortedEntries = new TreeSet<>((e1, e2) -> {
            int maxE1 = Math.max(e1.getValue()[0], Math.max(e1.getValue()[1], e1.getValue()[2]));
            int maxE2 = Math.max(e2.getValue()[0], Math.max(e2.getValue()[1], e2.getValue()[2]));
            return maxE1 - maxE2;
        });
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public static void main(String[] args) {
        int[] result = new BS3().getTriggerTime(new int[][] { { 2, 8, 4 }, { 2, 5, 0 }, { 10, 9, 8 } },
                new int[][] { { 2, 11, 3 }, { 15, 10, 7 }, { 9, 17, 12 }, { 8, 1, 14 } });
        for (int i : result) {
            System.out.println(i);
        }
        result = new BS3().getTriggerTime(new int[][] {{0,4,5},{4,8,8},{8,6,1},{10,10,0}},
                new int[][] {{12,11,16},{20,2,6},{9,2,6},{10,18,3},{8,14,9}});
        for (int i : result) {
            System.out.println(i);
        }
    }

}
