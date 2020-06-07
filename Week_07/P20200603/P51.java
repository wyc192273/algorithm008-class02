package leetcode2.P20200603;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-queens/description/
 * Created by yuchen.wu on 2020-06-03
 */

public class P51 {

    boolean[] cols;
    boolean[] pie;
    boolean[] na;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        char[][] chars = new char[n][n];
        for (char[] ch : chars) {
            Arrays.fill(ch, '.');
        }
        cols = new boolean[n];
        pie = new boolean[2 * n];
        na = new boolean[2 * n - 1];
        List<List<String>> result = new ArrayList<>();
        solveNQueens(0, n, chars, result);
        return result;
    }

    private void solveNQueens(int i, int n, char[][] board, List<List<String>> result) {
        if (i == n) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(new String(chars));
            }
            result.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            int naj = i + j;
            int piej = i - j + n;
            if (cols[j] || pie[piej] || na[naj]) {
                continue;
            }
            board[i][j] = 'Q';
            cols[j] = true;
            pie[piej] = true;
            na[naj] = true;
            solveNQueens(i + 1, n, board, result);
            board[i][j] = '.';
            cols[j] = false;
            pie[piej] = false;
            na[naj] = false;
        }
    }

}
