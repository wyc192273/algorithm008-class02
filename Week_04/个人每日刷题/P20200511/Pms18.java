package leetcode.P20200511;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode prev = tempHead;
        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
                break;
            }
            prev = prev.next;
            head = head.next;
        }
        return tempHead.next;
    }

}
