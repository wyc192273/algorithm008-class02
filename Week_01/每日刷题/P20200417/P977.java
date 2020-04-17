package leetcode.P20200417;

import org.python.antlr.op.LtE;

/**
 * Created by yuchen.wu on 2020-04-17
 */

public class P977 {

    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] result = new int[A.length];
        int index = A.length -1;
        while (left <= right) {
            if (Math.abs(A[left]) > Math.abs(A[right])) {
                result[index--] = A[left] * A[left++];
            } else {
                result[index--] = A[right] * A[right--];
            }
        }
        return result;
    }

    public int[] sortedSquares2(int[] A) {
        int index = binarySearchLess(A, 0);
        int[] result = new int[A.length];
        int insertIndex = 0;
        int left = -1;
        int right = 0;
        if (index != -1) {
            left = index;
            right = index + 1;
        }
        while (left >= 0 || right < A.length) {
            if (left < 0) {
                result[insertIndex++] = A[right] * A[right++];
            } else if (right >= A.length) {
                result[insertIndex++] = A[left] * A[left--];
            } else if (-A[left] > A[right]) {
                result[insertIndex++] = A[right] * A[right++];
            } else {
                result[insertIndex++] = A[left] * A[left--];
            }
        }
        return result;
    }

    private int binarySearchLess(int[] A, int num) {
        int l = 0;
        int h = A.length - 1;
        while (l < h) {
            int mid = (l + h + 1) >>> 1;
            if (A[mid] >= num) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        if (A[h] < num) {
            return h;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[] { -4,-3, -1, 1, 4 };
        System.out.println(new P977().binarySearchLess(arrays, 2));
    }

}
