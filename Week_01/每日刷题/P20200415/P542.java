package leetcode.P20200415;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/01-matrix/
 * Created by yuchen.wu on 2020-04-15
 *
 */

public class P542 {

    int[] rx = new int[] { 0, 0, -1, 1 };
    int[] ry = new int[] { -1, 1, 0, 0 };

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    result[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + rx[k];
                int ny = y + ry[k];
                if (nx >= 0 && ny >= 0 && nx < maxX && ny < maxY && result[nx][ny] == -1) {
                    result[nx][ny] = result[x][y] + 1;
                    queue.offer(new int[] { nx, ny });
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] aa = new int[][] { { 0, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 0, 0, 0, 1, 1 },
                { 1, 0, 1, 0, 1, 1, 1, 0, 1, 1 }, { 0, 0, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 0, 1, 0, 0, 1, 1 }, { 1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 1, 0 } };
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[i].length; j++) {
                System.out.printf(" " + aa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
