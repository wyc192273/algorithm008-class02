package leetcode.P20200511;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 0;
        ListNode tempHead = head;
        while (head != null) {
            head = head.next;
            length++;
        }
        if (length < k) {
            return null;
        }
        if (length == k) {
            return tempHead;
        }
        while (length != k) {
            length--;
            tempHead = tempHead.next;
        }
        return tempHead;
    }

}
