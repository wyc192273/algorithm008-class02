package leetcode.P20200427;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuchen.wu on 2020-04-27
 */

public class Pms40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        int index = quickSort(arr, 0, arr.length - 1, k);
        if (index == -1) {
            return new int[0];
        }
        int[] result = new int[k];
        for (int i = 0; i <= index; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private int quickSort(int[] arr, int l, int h, int k) {
        if (l > h) {
            return -1;
        }
        int p = partition(arr, l, h);
        if (p + 1 == k) {
            return p;
        } else if (p < k) {
            return quickSort(arr, p + 1, h, k);
        } else {
            return quickSort(arr, l, p - 1, k);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int v = arr[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && arr[i] < v);
            while (--j >= lo && arr[j] > v);
            if (i >= j) {
                break;
            }
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }
        arr[lo] = arr[j];
        arr[j] = v;
        return j;
    }

    public static void main(String[] args) {
        new Pms40().getLeastNumbers(new int[] { 3, 2, 1 }, 2);
    }

    /**
     * O(nlogk)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int i : arr) {
            if (queue.size() == k) {
                if (queue.peek() > i) {
                    queue.poll();
                    queue.add(i);
                }
            } else {
                queue.add(i);
            }
        }
        int[] result = new int[k];
        for (int i = queue.size() - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }

}
