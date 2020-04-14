package leetcode.P20200414;

import java.util.Stack;

import leetcode.ListNode;

/**
 * 题目链接：https://leetcode-cn.com/problems/add-two-numbers-ii/
 * Created by yuchen.wu on 2020-04-14
 */

public class P445 {

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode h = l1;
        while (h != null) {
            stack1.push(h);
            h = h.next;
        }
        h = l2;
        while (h != null) {
            stack2.push(h);
            h = h.next;
        }
        boolean returnL1 = stack1.size() >= stack2.size();
        ListNode tempHead = new ListNode(0);
        tempHead.next = returnL1 ? l1 : l2;
        boolean incr = false;
        while (true) {
            l1 = stack1.isEmpty() ? null : stack1.pop();
            l2 = stack2.isEmpty() ? null : stack2.pop();
            if (l1 == null && l2 == null) {
                break;
            }
            if (returnL1) {
                incr = incrListNode(l1, l2, incr);
            } else {
                incr = incrListNode(l2, l1, incr);
            }
        }
        if (incr) {
            ListNode newHead = new ListNode(1);
            newHead.next = tempHead.next;
            return newHead;
        }
        return tempHead.next;
    }

    private boolean incrListNode(ListNode l1, ListNode l2, boolean incr) {
        l1.val = l2 == null ? l1.val : l1.val + l2.val;
        if (incr) {
            l1.val = l1.val + 1;
        }
        int value = l1.val;
        l1.val = l1.val % 10;
        return value != l1.val;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop().val;
            sum += stack2.isEmpty() ? 0 : stack2.pop().val;
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

}
