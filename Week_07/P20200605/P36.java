package leetcode2.P20200605;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/description/
 * Created by yuchen.wu on 2020-06-05
 */

public class P36 {

    boolean[][] cols;
    boolean[][] rows;
    boolean[][] boards;

    public boolean isValidSudoku(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        cols = new boolean[9][10];
        rows = new boolean[9][10];
        boards = new boolean[9][10];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == '.') {
                    continue;
                }
                if (rows[x][getNum(board[x][y])]) {
                    return false;
                }
                if (cols[y][getNum(board[x][y])]) {
                    return false;
                }
                if (boards[getBoardIndex(x, y)][getNum(board[x][y])]) {
                    return false;
                }
                rows[x][getNum(board[x][y])] = true;
                cols[y][getNum(board[x][y])] = true;
                boards[getBoardIndex(x, y)][getNum(board[x][y])] = true;
            }
        }
        return true;
    }

    private int getNum(char c) {
        return c - '0';
    }

    private int getBoardIndex(int x, int y) {
        return x / 3 * 3+ y / 3;
    }

    public static void main(String[] args) {
        char[][] chars = new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' }, { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' }, { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' }, { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        new P36().isValidSudoku(chars);

        P36 p36 = new P36();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                System.out.println(p36.getBoardIndex(i, j));
            }
        }
    }

}
