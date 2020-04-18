package leetcode.P20200418;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class BS4_notFinish {

    Set<Integer> hasRange = new HashSet<>();
    int result = Integer.MAX_VALUE;

    public int minJump(int[] jump) {
        if (jump.length == 1) {
            return 1;
        }
        minJumpHelp(jump, 0, 0);
        return result;
    }

    public void minJumpHelp(int[] jump, int index, int k) {
        if (index > jump.length - 1) {
            result = Math.min(result, k);
            return;
        }
        if (hasRange.contains(index)) {
            return;
        }
        hasRange.add(index);
        int left = index - jump[index];
        if (left > 0) {
            minJumpHelp(jump, left, k + 1);
        }
        minJumpHelp(jump, index + jump[index], k + 1);
    }

    public static void main(String[] args) {
//        System.out.println(new BS4().minJump(new int[] { 2, 5, 1, 1, 1, 1 }));
//        System.out.println(new BS4().minJump(new int[] { 2, 3, 1, 1, 2, 1 }));
//        System.out.println(new BS4().minJump(new int[] { 3,7,6,1,4,3,7,8,1,2,8,5,9,8,3,2,7,5,1,1 }));
    }

}
