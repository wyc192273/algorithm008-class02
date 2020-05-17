package leetcode.P20200511;

/**
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return findNumberIn2DArray2(matrix, 0, matrix[0].length -1, target);
    }

    private boolean findNumberIn2DArray2(int[][] matrix, int row, int col, int target) {
        if (row >= matrix.length || col < 0) {
            return false;
        }
        if (matrix[row][col] == target) {
            return true;
        } else if (matrix[row][col] < target) {
            return findNumberIn2DArray2(matrix, row + 1, col, target);
        } else {
            return findNumberIn2DArray2(matrix, row, col - 1, target);
        }
    }
}
