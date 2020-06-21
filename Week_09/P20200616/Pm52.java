package leetcode2.P20200616;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * Created by yuchen.wu on 2020-06-16
 */

public class Pm52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode originHeadA = headA;
        ListNode originHeadB = headB;
        while (headA != headB) {
            headA = headA == null ? originHeadB : headA.next;
            headB = headB == null ? originHeadA : headB.next;
        }
        return headA;
    }

}
