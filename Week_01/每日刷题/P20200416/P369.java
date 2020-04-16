package leetcode.P20200416;

import java.util.Stack;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/plus-one-linked-list/
 * Created by yuchen.wu on 2020-04-16
 */

public class P369 {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head
     * @return
     */
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int carry = 1;
        head = null;
        while (carry != 0 || !stack.isEmpty()) {
            ListNode node = stack.isEmpty() ? new ListNode(0) : stack.pop();
            node.next = head;
            int sum = node.val + carry;
            carry = sum / 10;
            node.val = sum % 10;
            head = node;
        }
        return head;
    }

}
