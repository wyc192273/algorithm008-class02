package leetcode.P20200427;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * Created by yuchen.wu on 2020-04-27
 */

public class P23_2 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        for (int step = 1; step < lists.length; step <<= 1) {
            for (int i = 0; i < lists.length - step; i += step * 2) {
                if (i + step >= lists.length) {
                    continue;
                }
                lists[i] = merge(lists[i], lists[i + step]);
            }
        }
        return lists[0];
    }

    private ListNode merge(ListNode listNode, ListNode listNode2) {
        ListNode tempNode = new ListNode(-1);
        ListNode newHead = tempNode;
        while (listNode != null && listNode2 != null) {
            if (listNode.val < listNode2.val) {
                tempNode.next = listNode;
                listNode = listNode.next;
            } else {
                tempNode.next = listNode2;
                listNode2 = listNode2.next;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = listNode == null ? listNode2 : listNode;
        return newHead.next;
    }

}
