package leetcode.P20200511;

import leetcode.ListNode;
import leetcode.P20200427.Pms40;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * Created by yuchen.wu on 2020-05-11
 */

public class Pms62 {

    public int lastRemaining(int n, int m) {
        ListNode newHead = new ListNode(0);
        ListNode preHead = newHead;
        for (int i = 1; i < n;i++) {
            newHead.next = new ListNode(i);
            newHead = newHead.next;
        }
        newHead.next = preHead;
        int index = 1;
        ListNode prev = newHead;
        ListNode cur = preHead;
        while (prev != cur) {
            if (index % m == 0) {
                n--;
                prev.next = cur.next;
            } else {
                prev = prev.next;
            }
            cur = cur.next;
        }
        return cur.val;
    }

    public static void main(String[] args) {
        new Pms62().lastRemaining(5, 3);
    }

}
