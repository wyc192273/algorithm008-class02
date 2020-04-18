package leetcode.P20200418;

import leetcode.ListNode;

/**
 * Created by yuchen.wu on 2020-04-18
 */

public class P148_5 {

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        for (int step = 1; step < n; step <<= 1) {
            ListNode prev = tempHead;
            cur = prev.next;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, step);
                cur = split(right, step);
                prev = merge(left, right, prev);
            }
        }
        return tempHead.next;
    }

    private ListNode split(ListNode head, int step) {
        if (head == null) {
            return head;
        }
        for (int i = 1; i < step && head.next != null; i++) {
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }

    private ListNode merge(ListNode left, ListNode right, ListNode prev) {
        while (left != null && right != null) {
            if (left.val < right.val) {
                prev.next = left;
                left = left.next;
            } else {
                prev.next = right;
                right = right.next;
            }
            prev = prev.next;
        }
        prev.next = left == null ? right : left;
        while (prev.next != null) {
            prev = prev.next;
        }
        return prev;
    }
}
