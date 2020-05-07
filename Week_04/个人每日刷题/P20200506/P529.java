package leetcode.P20200506;

/**
 * https://leetcode-cn.com/problems/minesweeper/description/
 * Created by yuchen.wu on 2020-05-06
 */

public class P529 {

    private int rx[] = new int[] { 0, 0, 1, -1, 1, 1, -1, -1 };
    private int ry[] = new int[] { -1, 1, 0, 0, -1, 1, 1, -1 };

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        if (board[x][y] == 'E') {
            updateHelp(board, x, y);
        }
        return board;
    }

    private void updateHelp(char[][] board, int x, int y) {
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
            return;
        }
        if (board[x][y] != 'E') {
            return;
        }
        int mineCount = getMineCount(board, x, y);
        if (mineCount == 0) {
            board[x][y] = 'B';
        } else {
            board[x][y] = (char) (mineCount + '0');
            return;
        }
        for (int k = 0; k < 8; k++) {
            int nx = x + rx[k];
            int ny = y + ry[k];
            updateHelp(board, nx, ny);
        }
    }

    private int getMineCount(char[][] board, int x, int y) {
        int result = 0;
        for (int k = 0; k < 8; k++) {
            int nx = x + rx[k];
            int ny = y + ry[k];
            if (nx >= board.length || ny >= board[0].length || nx < 0 || ny < 0) {
                continue;
            }
            if (board[nx][ny] == 'M') {
                result++;
            }
        }
        return result;
    }

}
