package leetcode.P20200501;

import leetcode.ListNode;

/**
 * Created by yuchen.wu on 2020-05-01
 */

public class P21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode newHead = temp;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

}
