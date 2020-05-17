package leetcode.P20200512;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/max-stack/
 * Created by yuchen.wu on 2020-05-12
 */

public class P716 {

    class MaxStack {

        TreeMap<Integer, List<Node>> map;
        DoubleLinkedList doubleLinkedList;


        /** initialize your data structure here. */
        public MaxStack() {
            doubleLinkedList = new DoubleLinkedList();
            map = new TreeMap<>();
        }

        public void push(int x) {
            Node node = doubleLinkedList.add(x);
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(node);
        }

        public int pop() {
            int val = doubleLinkedList.pop();
            List<Node> list = map.get(val);
            Node node = list.remove(list.size() - 1);
            doubleLinkedList.unlink(node);
            if (list.isEmpty()) {
                map.remove(val);
            }
            return val;
        }

        public int top() {
            return doubleLinkedList.peek();
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int val = map.lastKey();
            List<Node> list = map.get(val);
            Node node = list.remove(list.size() - 1);
            doubleLinkedList.unlink(node);
            if (list.isEmpty()) {
                map.remove(val);
            }
            return val;
        }
    }

    class DoubleLinkedList{
        Node head, tail;

        public DoubleLinkedList() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public Node add(int val) {
            Node node = new Node(val);
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = tail.prev.next = node;
            return node;
        }

        public int pop() {
            return unlink(tail.prev).val;
        }

        public int peek() {
            return tail.prev.val;
        }

        public Node unlink(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            return node;
        }

    }

    class Node {
        int val;
        Node prev, next;
        public Node(int v) {val = v;}
    }

    class MaxStack2 {

        LinkedList<Integer> data;
        PriorityQueue<Integer> queue;


        /** initialize your data structure here. */
        public MaxStack2() {
            data = new LinkedList<>();
            queue = new PriorityQueue<>(Comparator.reverseOrder());
        }

        public void push(int x) {
            data.push(x);
            queue.add(x);
        }

        public int pop() {
            Integer top = data.pop();
            queue.remove(top);
            return top;
        }

        public int top() {
            return data.peek();
        }

        public int peekMax() {
            return queue.peek();
        }

        public int popMax() {
            int top = queue.poll();
            data.removeFirstOccurrence(top);
            return top;
        }
    }

}
