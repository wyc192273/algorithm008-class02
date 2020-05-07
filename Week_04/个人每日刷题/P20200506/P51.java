package leetcode.P20200506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/n-queens/
 * Created by yuchen.wu on 2020-05-06
 */

public class P51 {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> pie = new HashSet<>();
    Set<Integer> na = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(0, result, new ArrayList<>(), n);
        return result;
    }

    private void solveNQueens(int line, List<List<String>> result, List<String> solve, int n) {
        if (line == n) {
            result.add(new ArrayList<>(solve));
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int j = 0; j < n; j++) {
            if (cols.contains(j) || pie.contains(line + j) || na.contains(line - j)) {
                continue;
            }
            cols.add(j);
            pie.add(line + j);
            na.add(line - j);
            chars[j] = 'Q';
            solve.add(new String(chars));
            solveNQueens(line + 1, result, solve, n);
            cols.remove(j);
            pie.remove(line + j);
            na.remove(line - j);
            chars[j] = '.';
            solve.remove(solve.size() - 1);
        }
    }



    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> result = new ArrayList<>();
        solveNQueens(0, result, new ArrayList<>(), n);
        return result;
    }

    private void solveNQueens2(int line, List<List<String>> result, List<String> solve, int n) {
        if (line == n) {
            result.add(new ArrayList<>(solve));
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        for (int j = 0; j < n; j++) {
            if (checkSolve(line, j, n, solve)) {
                chars[j] = 'Q';
                solve.add(new String(chars));
                solveNQueens(line + 1, result, solve, n);
                solve.remove(solve.size() - 1);
                chars[j] = '.';
            }
        }
    }

    private boolean checkSolve(int x, int y, int n, List<String> solve) {
        int prevY = y;
        int lastY = y;
        for (int i = x - 1; i >= 0; i--) {
            if (solve.get(i).charAt(y) == 'Q') {
                return false;
            }
            prevY--;
            lastY++;
            if (prevY >= 0 && solve.get(i).charAt(prevY) == 'Q') {
                return false;
            }
            if (lastY < n && solve.get(i).charAt(lastY) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new P51().solveNQueens(4);

    }

}
