package leetcode.P20200429;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuchen.wu on 2020-04-29
 */

public class PAllRange {

    List<int[]> result = new ArrayList<>();

    public List<int[]> allArray(int k) {
        add(0, k, new int[k]);
        return result;
    }

    public void add(int index, int k, int[] res) {
        if (index == k) {
            int[] newR = new int[res.length];
            System.arraycopy(res, 0, newR, 0, res.length);
            result.add(newR);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            res[index] = i;
            add(index + 1, k, res);
        }
    }

    public static void main(String[] args) {
        List<int[]> list = new PAllRange().allArray(4);
        for (int[] l : list) {
            for (int i : l) {
                System.out.printf(i + " ");
            }
            System.out.println();
        }
        System.out.println(list.size());
    }
}
