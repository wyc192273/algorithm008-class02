package leetcode2.P20200611;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/#/
 * Created by yuchen.wu on 2020-06-11
 */

public class P146 {

    static class LRUCache {

        Map<Integer, Node> data;
        Node head;
        Node last;
        int capacity;

        public LRUCache(int capacity) {
            this.data = new HashMap<>((int) (capacity * 0.75) + 1);
            this.head = new Node(null, null, 0, 0);
            this.last = new Node(this.head, null, 0, 0);
            this.head.next = this.last;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = data.get(key);
            if (node == null) {
                return -1;
            }
            if (node.prev == head) {
                return node.value;
            }
            node.remove();
            head.add(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = data.get(key);
            if (node == null) {
                if (data.size() == capacity) {
                    Node lastNode = last.prev.remove();
                    data.remove(lastNode.key);
                }
                node = new Node(null, null, key, value);
                head.add(node);
                data.put(key, node);
            } else {
                node.value = value;
                node.remove();
                head.add(node);
            }
        }

        private class Node{
            private Node prev;
            private Node next;
            private int value;
            private int key;

            public Node(Node prev, Node next, int key, int value) {
                this.prev = prev;
                this.next = next;
                this.value = value;
                this.key = key;
            }

            public Node remove() {
                this.prev.next = this.next;
                this.next.prev = this.prev;
                return this;
            }

            public void add(Node node) {
                node.next = this.next;
                this.next.prev = node;
                this.next = node;
                node.prev = this;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
    }

}
