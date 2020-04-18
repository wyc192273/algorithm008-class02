package leetcode.P20200418;

import leetcode.ListNode;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class P143_5 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        rightHead = reverse(rightHead);
        slow = head;
        while (rightHead != null) {
            ListNode rightNext = rightHead.next;
            rightHead.next = slow.next;
            slow.next = rightHead;
            slow = slow.next.next;
            rightHead = rightNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
