package leetcode.P20200509;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * Created by yuchen.wu on 2020-05-09
 */

public class P51 {

    boolean[] cols;
    boolean[] pie;
    boolean[] na;


    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        pie = new boolean[2 * n - 1];
        na = new boolean[2 * n + 1];
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueens(0, result, board, n);
        return result;
    }

    public void solveNQueens(int line, List<List<String>> result, char[][] board, int n) {
        if (line == n) {
            List<String> lines = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                lines.add(new String(board[i]));
            }
            result.add(lines);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (cols[j] || pie[n + line - j] || na[line + j]) {
                continue;
            }
            board[line][j] = 'Q';
            cols[j] = true;
            pie[n + line - j] = true;
            na[line + j] = true;
            solveNQueens(line + 1, result, board, n);
            cols[j] = false;
            pie[n + line - j] = false;
            na[line + j] = false;
            board[line][j] = '.';
        }
    }

}
