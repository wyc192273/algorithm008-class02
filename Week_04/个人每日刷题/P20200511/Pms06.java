package leetcode.P20200511;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms06 {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ListNode tempHead = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        int[] result = new int[length];
        int i = result.length - 1;
        while (tempHead != null) {
            result[i--] = tempHead.val;
            tempHead = tempHead.next;
        }
        return result;
    }

}
