package leetcode.P20200512;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * Created by yuchen.wu on 2020-05-12
 */

public class P155 {

    class MinStack {

        class Node {
            int value;
            int min;
            Node next;

            public Node(int value, int min, Node next) {
                this.value = value;
                this.min = min;
                this.next = next;
            }
        }
        Node head;

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x, null);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }
    }

    class MinStack2 {

        Stack<Integer> data;
        Stack<Integer> help;

        /** initialize your data structure here. */
        public MinStack2() {
            data = new Stack<>();
            help = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (help.isEmpty() || x <= help.peek()) {
                help.push(x);
            }
        }

        public void pop() {
            int top = data.pop();
            if (help.peek() == top) {
                help.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return help.peek();
        }
    }

}
