package leetcode.P20200501;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * Created by yuchen.wu on 2020-05-01
 */

public class P200 {

    int[] rx = new int[] { 0, 0, -1, 1 };
    int[] ry = new int[] { -1, 1, 0, 0 };


    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length|| grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int k = 0; k < 4; k++) {
            int nx = rx[k] + x;
            int ny = ry[k] + y;
            bfs(grid, nx, ny);
        }
    }

    public static void main(String[] args) {
        new P200().numIslands(new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } });
    }

}
