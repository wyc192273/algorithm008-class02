package leetcode.P20200429;

import java.util.Stack;

import leetcode.ListNode;

/**
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * Created by yuchen.wu on 2020-04-29
 */

public class Pms06 {

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            int v = stack.pop();
            result[index++] = v;
        }
        return result;
    }

    public int[] reversePrint2(ListNode head) {
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        int[] result = new int[length];
        head = tempHead.next;
        while (head != null) {
            result[--length] = head.val;
            head = head.next;
        }
        return result;
    }
}
