package leetcode2.P20200613;

/**
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * Created by yuchen.wu on 2020-06-13
 */

public class Pms40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int l = 0;
        int h = arr.length - 1;
        int p = partition(arr, l, h);
        while (p != k - 1) {
            if (p > k - 1) {
                h = p - 1;
            } else {
                l = p + 1;
            }
            p = partition(arr, l, h);
        }
        int[] result = new int[k];
        for (int i = 0; i <= p; i++) {
            result[i] = arr[i];
        }
        return result;
    }


    private int partition(int[] arr, int l, int h) {
        int v = arr[l];
        //[l+1, i) < v
        //(j, h] >= v
        int i = l+1;
        int j = h;
        while (true) {
            while (i <= h && arr[i] < v) {
                i++;
            }
            while (j >= l + 1 && arr[j] >= v) {
                j--;
            }
            if (i >= j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;
        return j;
    }

    public static void main(String[] args) {
        new Pms40().getLeastNumbers(new int[] {0,1,2,1}, 1);

    }

}
