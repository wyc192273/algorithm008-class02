package leetcode2.P20200605;

/**
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * Created by yuchen.wu on 2020-06-05
 */

public class Pms29 {

    int[] rx = { 0, 1, 0, -1 };
    int[] ry = { 1, 0, -1, 0 };

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int k = 0;
        boolean[][] visited = new boolean[m][n];
        int index = 0;
        int x = 0;
        int y = 0;
        while (index < m * n) {
            result[index++] = matrix[x][y];
            visited[x][y] = true;
            int nx = rx[k] + x;
            int ny = ry[k] + y;
            if (nx < 0 || ny < 0 || nx == m || ny == n || visited[nx][ny]) {
                k = (k + 1) % 4;
                nx = rx[k] + x;
                ny = ry[k] + y;
            }
            x = nx;
            y = ny;
        }
        return result;
    }

    public static void main(String[] args) {
        new Pms29().spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }

}
