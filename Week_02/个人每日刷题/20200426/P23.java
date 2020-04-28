package leetcode.P20200426;

import leetcode.ListNode;

/**
 * Created by yuchen.wu on 2020-04-26
 */

public class P23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode tempHead = new ListNode(0);
        for (int step = 1; step < lists.length; step <<= 1) {
            for (int i = 0; i < lists.length; i += 2 * step) {
                if (i + step < lists.length) {
                    lists[i] = mergeTwoListNode(lists[i], lists[i + step]);
                }
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoListNode(ListNode listNode, ListNode listNode2) {
        ListNode tempHead = new ListNode(0);
        ListNode newHead = tempHead;
        while (listNode != null && listNode2 != null) {
            if (listNode.val < listNode2.val) {
                tempHead.next = listNode;
                listNode = listNode.next;
            } else {
                tempHead.next = listNode2;
                listNode2 = listNode2.next;
            }
            tempHead = tempHead.next;
        }
        tempHead.next = listNode == null ? listNode2 : listNode;
        return newHead.next;
    }

}
