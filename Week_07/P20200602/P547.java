package leetcode2.P20200602;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/friend-circles/
 * Created by yuchen.wu on 2020-06-02
 */

public class P547 {

    public int findCircleNum(int[][] M) {
        int[] relation = new int[M.length];
        Arrays.fill(relation, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                if (relation[j] == -1) {
                    relation[i] = j;
                } else {
                    if (relation[i] == -1) {
                        relation[i] = relation[j];
                    } else {
                        fillRelation(relation, relation[i], relation[j]);
                    }
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int r : relation) {
            if (r == -1) {
                continue;
            }
            set.add(r);
        }
        return set.size();
    }

    private void fillRelation(int[] relation, int j, int k) {
        for (int i = 0; i < relation.length; i++) {
            if (relation[i] == j) {
                relation[i] = k;
            }
        }
    }

    public static void main(String[] args) {
        new P547().findCircleNum(new int[][] { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } });
    }
}
