package leetcode.P20200419;

import java.util.Stack;

/**
 * Created by yuchen.wu on 2020-04-19
 */

public class P155 {

    class MinStack {

        private Stack<Integer> data;
        private Stack<Integer> helper;

        /** initialize your data structure here. */
        public MinStack() {
            data = new Stack<>();
            helper = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if (helper.isEmpty() || x <= helper.peek()) {
                helper.push(x);
            }
        }

        public void pop() {
            int top = data.pop();
            if (helper.peek().equals(top)) {
                helper.pop();
            }
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return helper.peek();
        }

    }
    class MinStack2 {

        private static final int DEFAULT_CAPACITY = 20;
        int[] element;
        int elementCount = 0;
        int minIndex = 0;

        /** initialize your data structure here. */
        public MinStack2() {
            element = new int[DEFAULT_CAPACITY];
        }

        public void push(int x) {
            if (elementCount == element.length) {
                grow();
            }
            if (element[minIndex] > x) {
                minIndex = elementCount;
            }
            element[elementCount++] = x;
        }

        public void pop() {
            elementCount--;
            if (elementCount == minIndex) {
                minIndex = 0;
                for (int i = 0; i < elementCount; i++) {
                    if (element[i] < element[minIndex]) {
                        minIndex = i;
                    }
                }
            }
        }

        public int top() {
            return element[elementCount - 1];
        }

        public int getMin() {
            return element[minIndex];
        }

        private void grow() {
            int[] newElement = new int[element.length + element.length];
            System.arraycopy(element, 0, newElement, 0, element.length);
            element = newElement;
        }
    }


}
