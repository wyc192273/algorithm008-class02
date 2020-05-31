package leetcode.P20200528;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuchen.wu on 2020-05-28
 */

public class P77 {

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public void combine(int i, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (k - i + 1 > n - i - list.size()) {
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            combine(j + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }

    public void combine2(int i, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <= n; j++) {
            list.add(j);
            combine2(j + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }

}
