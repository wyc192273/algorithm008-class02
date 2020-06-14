package leetcode2.P20200614;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/design-a-leaderboard/
 * Created by yuchen.wu on 2020-06-14
 */

public class P1244 {
    static class Leaderboard {

        int[] scores;
        int[] player;

        public Leaderboard() {
            scores = new int[100001];
            player = new int[10001];
        }

        public void addScore(int playerId, int score) {
            if (player[playerId] != 0) {
                scores[player[playerId]]--;
            }
            player[playerId] += score;
            scores[player[playerId]]++;
        }

        public int top(int K) {
            int num = 0;
            int res = 0;
            for (int i = 100000; i >= 1; i--) {
                if (num + scores[i] >= K) {
                    res += (K - num) * i;
                    break;
                }
                num += scores[i];
                res += scores[i] * i;
            }
            return res;
        }

        public void reset(int playerId) {
            scores[player[playerId]]--;
            player[playerId] = 0;
        }
    }

    public static void main(String[] args) {
        Leaderboard l = new Leaderboard();
        l.addScore(1, 73);
        l.addScore(2, 56);
        l.addScore(3,39);
    }

}
