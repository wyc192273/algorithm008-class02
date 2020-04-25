package leetcode.P20200425;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/zero-matrix-lcci/
 * Created by yuchen.wu on 2020-04-25
 */

public class Pms0108 {


    public void setZeroes(int[][] matrix) {
        int[] x = new int[matrix.length];
        int[] y = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    x[i] = 1;
                    y[j] = 1;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (x[i] == 1 || y[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
